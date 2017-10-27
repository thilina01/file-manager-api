package com.trendsmixed.fma.module.absenteeism;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.labourtursource.LabourSource;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
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
@Table(name = "absenteeism")
public class Absenteeism implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(AbsenteeismView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(AbsenteeismView.EffectiveMonth.class)
    @Column(name = "effective_month")
    private Date effectiveMonth;
    @JsonView(AbsenteeismView.Absenteeism.class)
    @Column(name = "absenteeism")
    private double absenteeism;
    @JsonView(AbsenteeismView.Target.class)
    @Column(name = "target")
    private double target;
    @JsonView(AbsenteeismView.LabourSource.class)
    @JoinColumn(name = "labour_source_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LabourSource labourSource;

}
