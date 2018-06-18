package com.trendsmixed.fma.module.sectiontype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.section.Section;
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
@Table(name = "section_type")
public class SectionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SectionTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SectionTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(SectionTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "sectionType")
    private List<Section> sectionList;

    @JsonView(SectionTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
