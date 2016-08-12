package com.trendsmixed.fma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Folder;
import com.trendsmixed.fma.service.FolderService;

@RestController
@CrossOrigin
@RequestMapping("/folders")
public class FolderController {

	@Autowired
	private FolderService folderService;

	@PostMapping
	public Folder save(@RequestBody Folder folder){
		return folderService.save(folder);
	}

	@GetMapping
	public List<Folder> list(){
		return folderService.findAll();
	}

	@GetMapping("/{id}")
	public Folder one(@PathVariable("id") int id){
		return folderService.findOne(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id){
		folderService.delete(id);
	}

}
