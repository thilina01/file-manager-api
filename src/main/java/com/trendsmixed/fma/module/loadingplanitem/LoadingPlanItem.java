package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.loadingplan.LoadingPlan;
import com.trendsmixed.fma.module.packagingspecification.PackagingSpecification;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "loading_plan_item")
public class LoadingPlanItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(LoadingPlanItemView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(LoadingPlanItemView.CubicMeter.class)
    @Column(name = "cubic_meter ")
    private Double cubicMeter ; 
    @JsonView(LoadingPlanItemView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(LoadingPlanItemView.DispatchSchedule.class)
    @JoinColumn(name = "dispatch_schedule_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DispatchSchedule dispatchSchedule;
    @JsonView(LoadingPlanItemView.PackagingSpecification.class)
    @JoinColumn(name = "packaging_specification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PackagingSpecification packagingSpecification;
    @JsonView(LoadingPlanItemView.LoadingPlan.class)
    @JoinColumn(name = "loading_plan_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private LoadingPlan loadingPlan;
  
}