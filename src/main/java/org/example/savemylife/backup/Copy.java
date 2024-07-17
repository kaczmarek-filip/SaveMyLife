package org.example.savemylife.backup;

import org.example.savemylife.data.Task;
import org.example.savemylife.logs.Log;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Copy {

    private final Path sourcePath;
    private final Path targetPath;
    private final Task task;

    public Copy(Task task) {
        this.task = task;
        sourcePath = task.getSource().toPath();
        targetPath = task.getTarget().toPath();
    }

    public void copy() {
        try {
            Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path sourceFile, BasicFileAttributes attrs) {

                    Path targetFile = targetPath.resolve(sourcePath.relativize(sourceFile));
                    try {
                        if (Files.exists(targetFile) && !isContentDifferent(sourceFile, targetFile)) {
                            new Log(task, "The file " + sourceFile + " already exists and is identical, I omit.").show();
                        } else {
                            Files.createDirectories(targetFile.getParent());

                            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

                            new Log(task, "Copied from " + sourceFile + " to " + targetFile).show();
                        }
                    } catch (IOException e) {
                        new Log(task, "Error during copying " + sourceFile + " to " + targetFile + ": " + e.getMessage()).err();
                    }
                    return FileVisitResult.CONTINUE;
                } //TODO: Dodać logi
            });

            new Log(task, "Synchronisation successfully completed.").show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isContentDifferent(Path file1, Path file2) throws IOException {
        if (Files.size(file1) != Files.size(file2)) {
            return true;
        }
        return Files.mismatch(file1, file2) != -1;
    }
}
