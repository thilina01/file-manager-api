package com.trendsmixed.fma.module.manpower;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.manpowertype.ManpowerType;
import com.trendsmixed.fma.module.production.Production;
import javax.persistence.CascadeType;
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
@Table(name = "manpower")
public class Manpower implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(ManpowerView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(ManpowerView.PlannedQuantity.class)
    @Column(name = "planned_quantity")
    private Integer plannedQuantity;
    @JsonView(ManpowerView.ActualQuantity.class)
    @Column(name = "actual_quantity")
    private Integer actualQuantity;
    @JsonView(ManpowerView.ManpowerType.class)
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ManpowerType manpowerType;
    @JsonView(ManpowerView.Production.class)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Production production;

}
