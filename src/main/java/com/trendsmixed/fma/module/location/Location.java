package com.trendsmixed.fma.module.location;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.energyconsumption.EnergyConsumption;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;

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
@Table(name = "location")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LocationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LocationView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(LocationView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "location")
    private List<EnergyConsumption> energyConsumptionList;
    @JsonView(LocationView.DispatchNote.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "location", fetch = FetchType.LAZY)
    private List<DispatchNote> dispatchNoteList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "location", fetch = FetchType.LAZY)
    private List<SubcontractNote> SubcontractNoteList;

    public Location(Integer id) {
        this.id = id;
    }

    @JsonView(LocationView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
