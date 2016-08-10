package com.trwlanka.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trwlanka.Dummy;
import com.trwlanka.entity.Folder;

@RestController
public class IndexController {

    @GetMapping("/")
    public ArrayList <Folder> root() {
    	
    	return Dummy.getFolders();

    }
}
