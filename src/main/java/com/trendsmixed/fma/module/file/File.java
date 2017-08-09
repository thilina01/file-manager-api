/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.file;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.filetype.FileType;
import com.trendsmixed.fma.module.folder.Folder;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "file")
@NamedQueries({
    @NamedQuery(name = "File.findAll", query = "SELECT f FROM File f")})
public class File implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(FileView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(FileView.Link.class)
    @Column(name = "link")
    private String link;
    @JsonView(FileView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(FileView.Extension.class)
    @Column(name = "extension")
    private String extension;
    @JsonView(FileView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(FileView.OriginalFileName.class)
    @Column(name = "original_file_name")
    private String originalFileName;
    @JsonView(FileView.UploadDate.class)
    @Column(name = "upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @JoinTable(name = "folder_file", joinColumns = {
        @JoinColumn(name = "files_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "folders_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Folder> folderList;
    @JsonView(FileView.FileType.class)
    @JoinColumn(name = "file_type_id", referencedColumnName = "id")
    @ManyToOne
    private FileType fileType;

    public File() {
    }

    public File(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof File)) {
            return false;
        }
        File other = (File) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.File[ id=" + id + " ]";
    }

}
