package com.trendsmixed.fma.module.energyconsumption;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.location.Location;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "energy_consumption")

public class EnergyConsumption implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(EnergyConsumptionView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(EnergyConsumptionView.Kwh.class)
    @Column(name = "kwh")
    private Double kwh;
    @JsonView(EnergyConsumptionView.Kva.class)
    @Column(name = "kva")
    private Double kva;
    @JsonView(EnergyConsumptionView.Cost.class)
    @Column(name = "cost")
    private Double cost;
    @JsonView(EnergyConsumptionView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(EnergyConsumptionView.Reference.class)
    @Column(name = "reference")
    private String reference;
    @JsonView(EnergyConsumptionView.Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location location;

}
