package com.example.lld.file_search.file_system;

import com.example.lld.file_search.constants.FilesystemComponentType;
import lombok.Getter;

@Getter
public class File extends FilesystemComponent {

    public File(String name, int size, String extension) {
        super(name, size, extension, FilesystemComponentType.FILE);
    }
}
