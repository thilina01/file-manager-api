package com.trwlanka.entity;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Folder {
	@Id
	@GeneratedValue
	private Integer id;
	String name;
	Folder folder;
	ArrayList<Folder> folders;
	ArrayList<File> files;
}
