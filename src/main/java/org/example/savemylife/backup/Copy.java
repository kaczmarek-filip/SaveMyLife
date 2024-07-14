package org.example.savemylife.backup;

import org.example.savemylife.data.Task;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Copy {

    private final Path sourcePath;
    private final Path targetPath;

    public Copy(Task task) {
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
                            System.out.println("The file " + sourceFile + " already exists and is identical, I omit.");
                        } else {
                            Files.createDirectories(targetFile.getParent());

                            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
                            System.out.println("Copied from " + sourceFile + " to " + targetFile);
                        }
                    } catch (IOException e) {
                        System.err.println("Error during copying " + sourceFile + " to " + targetFile + ": " + e.getMessage());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Synchronisation successfully completed.");

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
