package com.example.lld.file_search.filter;

public interface FileFilter<T> {

    boolean isMatch(T item);

    default FileFilter<T> and(FileFilter<T> other){

        return item -> this.isMatch(item) && other.isMatch(item);
    }

    default FileFilter<T> or(FileFilter<T> other){

        return item -> this.isMatch(item) || other.isMatch(item);
    }
}
