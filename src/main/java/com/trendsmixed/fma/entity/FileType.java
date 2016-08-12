package com.trwlanka.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class FileType {
	@Id
	@GeneratedValue
	private Integer id;
	
	String name;
	
	@JsonIgnore	
	@OneToMany(mappedBy="fileType")
	private List<File> files;
}
