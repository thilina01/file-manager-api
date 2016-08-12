package com.trwlanka;

import java.util.ArrayList;

import com.trwlanka.entity.File;
import com.trwlanka.entity.FileType;
import com.trwlanka.entity.Folder;

public class Dummy {
	
	public static  ArrayList<Folder> getFolders() {
		ArrayList<Folder> folders = new ArrayList<>();
		for(int i= 0;i<10;i++){
			FileType fileType = new FileType();
			fileType.setName("Filetype "+i);

			File file = new File();
			file.setName("File "+i);
			file.setFileType(fileType);

			Folder folder = new Folder();
			folder.setName("Folder "+i);
			ArrayList<File> files = new ArrayList<>();
			files.add(file);
			folder.setFiles(files);
			folders.add(folder);			
		}
		
		return folders;
		
	}

}
