package com.trendsmixed.fma.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.Dummy;
import com.trendsmixed.fma.entity.Folder;

@RestController
@CrossOrigin
public class IndexController {

    @GetMapping("/")
    public ArrayList<Folder> root() {

        return Dummy.getFolders();

    }
}
