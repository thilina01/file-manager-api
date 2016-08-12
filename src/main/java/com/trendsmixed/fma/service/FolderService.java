package com.trwlanka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trwlanka.entity.Folder;
import com.trwlanka.repository.FolderRepository;

@Service
public class FolderService {

	@Autowired
	private FolderRepository folderRepository;

	public List<Folder> findAll() {
		return folderRepository.findAll();
	}
	
	public void save(Folder folder) {
		folderRepository.save(folder);
	}
}
