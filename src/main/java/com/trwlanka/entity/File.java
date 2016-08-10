package com.trwlanka.entity;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class File {
	@Id
	@GeneratedValue
	private Integer id;
	String name;
	String note;
	String Link;
	FileType fileType;
	ArrayList<Folder>folders;

}
