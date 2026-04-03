package com.example.lld.file_search.file_system;

import com.example.lld.file_search.constants.FilesystemComponentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public abstract class FilesystemComponent {

    private final String name;
    private final String extension;
    private final FilesystemComponentType type;

    @Setter
    private int size;

    public FilesystemComponent(String name, int size, String extension, FilesystemComponentType type) {
        this.name = name;
        this.size = size;
        this.extension = extension;
        this.type = type;
    }

    public void showData(){
        System.out.println(this);
    }
}
