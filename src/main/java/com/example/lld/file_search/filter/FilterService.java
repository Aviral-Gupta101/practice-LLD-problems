package com.example.lld.file_search.filter;


import java.util.List;

public interface FilterService<T> {

    List<T> filterFiles(List<T> allFiles, FileFilter<T> filter);
}
