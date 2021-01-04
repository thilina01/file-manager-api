package com.trendsmixed.fma.module.defect;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.itemtype.ItemType;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.section.Section;
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
@Table(name = "defect")
public class Defect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DefectView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DefectView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(DefectView.UnitValue.class)
    @Column(name = "unit_value")
    private double unitValue;
    @JsonView(DefectView.DefectDate.class)
    @Column(name = "defect_date")
    @Temporal(TemporalType.DATE)
    private Date defectDate;
    @JsonView(DefectView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Section section;
    @JsonView(DefectView.ItemType.class)
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemType;
    @JsonView(DefectView.LossReason.class)
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(DefectView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(DefectView.OperationType.class)
    @JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationType operationType;

}
