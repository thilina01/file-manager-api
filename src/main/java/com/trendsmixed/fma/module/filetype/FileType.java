package com.trendsmixed.fma.module.filetype;

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
@Table(name = "file_type")
public class FileType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(FileTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(FileTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "fileType")
    private List<File> fileList;

}
