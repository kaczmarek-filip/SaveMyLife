package org.example.savemylife.interfaces;

import java.util.List;

public interface JsonMethods<T> {
    void add(T t);
    void delete(T t);
    void update(T t);
}
