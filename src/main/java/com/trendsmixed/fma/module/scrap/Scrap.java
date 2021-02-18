package com.trendsmixed.fma.module.scrap;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.defect.DefectView;
import com.trendsmixed.fma.module.itemtype.ItemType;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.operation.Operation;
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
@Table(name = "scrap")
public class Scrap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ScrapView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ScrapView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Operation operation;
    @JsonView(ScrapView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(ScrapView.UnitValue.class)
    @Column(name = "unit_value")
    private double unitValue;
    @JsonView(ScrapView.ScrapDate.class)
    @Column(name = "scrap_date")
    @Temporal(TemporalType.DATE)
    private Date scrapDate;
    @JsonView(ScrapView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Section section;
    @JsonView(ScrapView.ItemType.class)
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemType;
    @JsonView(ScrapView.LossReason.class)
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(ScrapView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(ScrapView.OperationType.class)
    @JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationType operationType;

}
