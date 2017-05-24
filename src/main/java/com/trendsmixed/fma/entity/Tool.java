/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.tool.ToolView;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "tool")
@NamedQueries({
    @NamedQuery(name = "Tool.findAll", query = "SELECT m FROM Tool m")})
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ToolView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ToolView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(ToolView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tool")
    private List<ToolBreakdown> toolBreakdownList;

    public Tool() {
    }

    public Tool(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToolBreakdown> getToolBreakdownList() {
        return toolBreakdownList;
    }

    public void setToolBreakdownList(List<ToolBreakdown> toolBreakdownList) {
        this.toolBreakdownList = toolBreakdownList;
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
        if (!(object instanceof Tool)) {
            return false;
        }
        Tool other = (Tool) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Tool[ id=" + id + " ]";
    }

}
