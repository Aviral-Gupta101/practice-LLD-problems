package com.example.lld.file_search.filter;

import com.example.lld.file_search.constants.FilesystemComponentType;
import com.example.lld.file_search.file_system.Directory;
import com.example.lld.file_search.file_system.FilesystemComponent;

import java.util.ArrayList;
import java.util.List;

public class FileFilterService implements FilterService<FilesystemComponent> {

    private static volatile FileFilterService instance;

    private FileFilterService() {}

    public static FileFilterService getInstance(){

        if(instance == null){

            synchronized (FileFilterService.class){

                if(instance == null)
                    instance = new FileFilterService();
            }
        }

        return instance;
    }

    public List<FilesystemComponent> filterFiles(List<FilesystemComponent> allFiles, FileFilter<FilesystemComponent> filter){

        List<FilesystemComponent> res = new ArrayList<>();

        allFiles.forEach(item -> {

                if(item.getType() == FilesystemComponentType.FOLDER){

                    Directory d = (Directory) item;
                    List<FilesystemComponent> res2 = d.search(filter);
                    res.addAll(res2);
                }
                else {

                    if(filter.isMatch(item))
                        res.add(item);
                }

            }
        );

        return res;
    }
}
