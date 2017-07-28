package com.trendsmixed.fma;

import com.trendsmixed.fma.module.file.File;
import java.util.ArrayList;

import com.trendsmixed.fma.module.filetype.FileType;
import com.trendsmixed.fma.module.folder.Folder;

public class Dummy {

    public static ArrayList<Folder> getFolders() {
        ArrayList<Folder> folders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FileType fileType = new FileType();
            fileType.setName("Filetype " + i);

            File file = new File();
            file.setName("File " + i);
            file.setFileType(fileType);

            Folder folder = new Folder();
            folder.setName("Folder " + i);
            ArrayList<File> files = new ArrayList<>();
            files.add(file);
            folder.setFileList(files);
            folders.add(folder);
        }

        return folders;

    }

}
