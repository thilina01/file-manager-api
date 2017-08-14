/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.section;

import com.trendsmixed.fma.module.costcenter.CostCenter;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.sectiontype.SectionType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "section")
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s")})
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SectionView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SectionView.Code.class)
    @Column(name = "code",unique=true)
    private String code;
    @JsonView(SectionView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(SectionView.MTBFTarget.class)
    @Column(name = "mtbf_target")
    private Double mtbfTarget;
    @JsonView(SectionView.MTTRTarget.class)
    @Column(name = "mttr_target")
    private Double mttrTarget;
    @JsonView(SectionView.MDTTarget.class)
    @Column(name = "mdt_target")
    private Double mdtTarget;
    @JsonView(SectionView.SectionType.class)
    @JoinColumn(name = "section_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private SectionType sectionType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "section")
    private List<CostCenter> costCenterList;

    public Section(Integer id) {
        this.id = id;
    }

}
