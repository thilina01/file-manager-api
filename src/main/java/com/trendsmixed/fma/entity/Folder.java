package com.trendsmixed.fma.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Folder {
	@Id
	@GeneratedValue
	private Integer id;
	String name;
	String description;
	@ManyToOne
	Folder folder;
	@OneToMany(mappedBy = "folder")
	List<Folder> folders;
	@ManyToMany
	@JoinTable(name = "folder_file")
	private List<File> files;
}
