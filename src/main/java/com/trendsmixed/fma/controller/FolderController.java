package com.trwlanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trwlanka.entity.Folder;
import com.trwlanka.service.FolderService;

@RestController
@CrossOrigin
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	private FolderService folderService;
	
	@PostMapping
	public void save(@RequestBody Folder folder){
		folderService.save(folder);
	}

}
