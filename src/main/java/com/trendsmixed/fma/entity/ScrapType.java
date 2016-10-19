/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ScrapTypeView;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "scrap_type")
@NamedQueries({
    @NamedQuery(name = "ScrapType.findAll", query = "SELECT s FROM ScrapType s")})
public class ScrapType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ScrapTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ScrapTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(ScrapTypeView.Type.class)
    @Column(name = "type")
    private String type;
    @JsonView(ScrapTypeView.TypeInSinhala.class)
    @Column(name = "type_in_sinhala")
    private String typeInSinhala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scrapType")
    private List<RunDateHasScrapType> runDateHasScrapTypeList;

    public ScrapType() {
    }

    public ScrapType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeInSinhala() {
        return typeInSinhala;
    }

    public void setTypeInSinhala(String typeInSinhala) {
        this.typeInSinhala = typeInSinhala;
    }

    public List<RunDateHasScrapType> getRunDateHasScrapTypeList() {
        return runDateHasScrapTypeList;
    }

    public void setRunDateHasScrapTypeList(List<RunDateHasScrapType> runDateHasScrapTypeList) {
        this.runDateHasScrapTypeList = runDateHasScrapTypeList;
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
        if (!(object instanceof ScrapType)) {
            return false;
        }
        ScrapType other = (ScrapType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ScrapType[ id=" + id + " ]";
    }

}
