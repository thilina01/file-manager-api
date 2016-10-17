/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "defect_type")
@NamedQueries({
    @NamedQuery(name = "DefectType.findAll", query = "SELECT d FROM DefectType d")})
public class DefectType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "type_in_shinhala")
    private String typeInShinhala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defectType")
    private Collection<RunDateHasDefectType> runDateHasDefectTypeCollection;

    public DefectType() {
    }

    public DefectType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeInShinhala() {
        return typeInShinhala;
    }

    public void setTypeInShinhala(String typeInShinhala) {
        this.typeInShinhala = typeInShinhala;
    }

    public Collection<RunDateHasDefectType> getRunDateHasDefectTypeCollection() {
        return runDateHasDefectTypeCollection;
    }

    public void setRunDateHasDefectTypeCollection(Collection<RunDateHasDefectType> runDateHasDefectTypeCollection) {
        this.runDateHasDefectTypeCollection = runDateHasDefectTypeCollection;
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
        if (!(object instanceof DefectType)) {
            return false;
        }
        DefectType other = (DefectType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.DefectType[ id=" + id + " ]";
    }
    
}
