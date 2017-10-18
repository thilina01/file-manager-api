package com.trendsmixed.fma.module.processedscrap;

import com.trendsmixed.fma.module.lossreason.LossReason;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.section.Section;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "processed_scrap")
@NamedQueries({
    @NamedQuery(name = "ProcessedScrap.findAll", query = "SELECT i FROM ProcessedScrap i")})
public class ProcessedScrap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ProcessedScrapView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ProcessedScrapView.ProcessedDate.class)
    @Column(name = "processed_date")
    @Temporal(TemporalType.DATE)
    private Date processedDate;
    @JsonView(ProcessedScrapView.SubItemCode.class)
    @Column(name = "sub_item_code")
    private String subItemCode;
    @JsonView(ProcessedScrapView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(ProcessedScrapView.UnitCost.class)
    @Column(name = "unit_cost")
    private Double unitCost;
    @JsonView(ProcessedScrapView.LossReason.class)
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(ProcessedScrapView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Section section;

}
