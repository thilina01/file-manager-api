package com.trendsmixed.fma.module.folder;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.file.File;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "folder")
public class Folder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(FolderView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(FolderView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(FolderView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(FolderView.FileList.class)
    @ManyToMany(mappedBy = "folderList")
    private List<File> fileList;
    @JsonView(FolderView.FolderList.class)
    @OneToMany(mappedBy = "folder")
    private List<Folder> folderList;
    @JsonView(FolderView.Folder.class)
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    @ManyToOne
    private Folder folder;

}
