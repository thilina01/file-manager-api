package com.trendsmixed.fma.module.file;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.filetype.FileType;
import com.trendsmixed.fma.module.folder.Folder;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "file")
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

}
