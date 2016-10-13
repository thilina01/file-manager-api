package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.Views;
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
    @JsonView(Views.FolderOnly.class)
    private Integer id;
    @JsonView(Views.FolderOnly.class)
    String name;
    @JsonView(Views.FolderOnly.class)
    String description;
    @ManyToOne
    @JsonView(Views.FolderWithParent.class)
    Folder folder;

    @JsonView(Views.FolderWithSubFolders.class)
    @OneToMany(mappedBy = "folder")
    List<Folder> folders;

    @JsonView(Views.FolderWithFiles.class)
    @ManyToMany
    @JoinTable(name = "folder_file")
    private List<File> files;
}
