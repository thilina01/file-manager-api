package com.trendsmixed.fma.module.fileinformation;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "file_information")
public class FileInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(FileInformationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(FileInformationView.Link.class)
    @Column(name = "link")
    private String link;
    @JsonView(FileInformationView.Path.class)
    @Column(name = "path")
    private String path;
    @JsonView(FileInformationView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(FileInformationView.Extension.class)
    @Column(name = "extension")
    private String extension;
    @JsonView(FileInformationView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(FileInformationView.OriginalFileName.class)
    @Column(name = "original_file_name")
    private String originalFileName;
    @JsonView(FileInformationView.UploadDate.class)
    @Column(name = "upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;

}
