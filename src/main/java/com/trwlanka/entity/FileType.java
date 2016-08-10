package com.trwlanka.entity;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class FileType {
	@Id
	@GeneratedValue
	private Integer id;
	String name;
	ArrayList<File> files;
}
