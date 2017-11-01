package com.trendsmixed.fma.module.location;

import com.trendsmixed.fma.module.energyconsumption.EnergyConsumption;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
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

    public Location(Integer id) {
        this.id = id;
    }

    @JsonView(LocationView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
