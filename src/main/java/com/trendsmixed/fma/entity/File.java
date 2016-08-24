package com.trendsmixed.fma.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class File {
	@Id
	@GeneratedValue
	private Integer id;
	
	String name;
	String note;
	String Link;
        Date uploadDate;
	
	@ManyToOne
	FileType fileType;

	@ManyToMany(mappedBy = "files")
	private List<Folder> folders;

}
