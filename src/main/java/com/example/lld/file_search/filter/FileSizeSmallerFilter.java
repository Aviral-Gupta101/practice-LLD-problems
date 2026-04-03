package com.example.lld.file_search.filter;

import com.example.lld.file_search.file_system.FilesystemComponent;

public class FileSizeSmallerFilter implements FileFilter<FilesystemComponent> {

    private final int size;

    public FileSizeSmallerFilter(int size) {

        this.size = size;
    }

    @Override
    public boolean isMatch(FilesystemComponent item) {

        if(item == null)
            throw new IllegalArgumentException("FilesystemComponent can't be null");

        return item.getSize() <= size;
    }
}
