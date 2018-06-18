package com.trendsmixed.fma.module.labourturnover;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.labourtursource.LabourSource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "labour_turnover")
public class LabourTurnover implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LabourTurnoverView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LabourTurnoverView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(LabourTurnoverView.Turnover.class)
    @Column(name = "turnover")
    private double turnover;
    @JsonView(LabourTurnoverView.Target.class)
    @Column(name = "target")
    private double target;
    @JsonView(LabourTurnoverView.LabourSource.class)
    @JoinColumn(name = "labour_source_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LabourSource labourSource;

}
