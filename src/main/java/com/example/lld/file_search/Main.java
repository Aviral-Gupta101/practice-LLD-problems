package com.example.lld.file_search;

import com.example.lld.file_search.file_system.Directory;
import com.example.lld.file_search.file_system.File;
import com.example.lld.file_search.file_system.FilesystemComponent;
import com.example.lld.file_search.filter.FileFilter;
import com.example.lld.file_search.filter.FileNameFilter;
import com.example.lld.file_search.filter.FileSizeSmallerFilter;

public class Main {
    public static void main(String[] args) {

        File f1 = new File("file1", 100, "pdf");
        File f2 = new File("file2", 150, "xml");
        File f3 = new File("file3", 200, "css");
        File f4 = new File("file4", 250, "html");

        Directory d1 = new Directory("directory1");
        Directory d2 = new Directory("directory2");
        Directory d3 = new Directory("directory3");
        Directory d4 = new Directory("directory4");

        d1.addFiles(f1);
        d2.addFiles(f2);
        d3.addFiles(f3);
        d4.addFiles(f4);


        d1.addFiles(d2);
        d2.addFiles(d3);
        d3.addFiles(d4);

        // d1.showData(); // To print all files

        FileFilter<FilesystemComponent> filter = new FileNameFilter("file").and(new FileSizeSmallerFilter(200));

        d1.search(filter).forEach(FilesystemComponent::showData);
    }
}
