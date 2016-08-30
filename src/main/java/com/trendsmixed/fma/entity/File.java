package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.Views;
import java.util.Date;
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
    @JsonView(Views.FolderOnly.class)
    private Integer id;

    @JsonView(Views.FolderOnly.class)
    String name;
    @JsonView(Views.FolderOnly.class)
    String extension;
    @JsonView(Views.FolderOnly.class)
    String originalFileName;
    @JsonView(Views.FolderOnly.class)
    String description;
    @JsonView(Views.FolderOnly.class)
    String Link;
    @JsonView(Views.FolderOnly.class)
    Date uploadDate;

    @ManyToOne
    FileType fileType;

    @ManyToMany(mappedBy = "files")
    private List<Folder> folders;

}
