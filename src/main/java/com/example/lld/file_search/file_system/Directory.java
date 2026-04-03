package com.example.lld.file_search.file_system;

import com.example.lld.file_search.constants.FilesystemComponentType;
import com.example.lld.file_search.filter.FileFilter;
import com.example.lld.file_search.filter.FileFilterService;
import com.example.lld.file_search.filter.FilterService;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Directory extends FilesystemComponent {

    private final List<FilesystemComponent> files;
    private final FilterService<FilesystemComponent> fileFilterService = FileFilterService.getInstance();

    public Directory(String name) {
        super(name, 0, "", FilesystemComponentType.FOLDER);
        files = new ArrayList<>();
    }

    public void addFiles(FilesystemComponent file){

        files.add(file);
        setSize(getSize() + file.getSize());
    }

    public void removeFile(FilesystemComponent file){

        if(files.remove(file)){
            setSize(getSize() - file.getSize());
        }
    }

    public List<FilesystemComponent> search(FileFilter<FilesystemComponent> filter){
        return fileFilterService.filterFiles(files, filter);
    }

    @Override
    public void showData() {
        System.out.println(this);
        files.forEach(FilesystemComponent::showData);
    }
}
