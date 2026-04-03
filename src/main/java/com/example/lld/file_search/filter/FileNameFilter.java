package com.example.lld.file_search.filter;

import com.example.lld.file_search.file_system.FilesystemComponent;

public class FileNameFilter implements FileFilter<FilesystemComponent> {

    private final String pattern;

    public FileNameFilter(String pattern) {

        if(pattern == null || pattern.isBlank())
            throw new IllegalArgumentException("Pattern can't be null or blank");


        this.pattern = pattern;
    }

    @Override
    public boolean isMatch(FilesystemComponent item) {

        if(item == null)
            throw new IllegalArgumentException("FilesystemComponent can't be null");

        return pattern.equals(item.getName()) || item.getName().startsWith(pattern);
    }
}
