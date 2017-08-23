/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.scrap;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.producttype.ProductType;
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
@Table(name = "scrap")
@NamedQueries({
    @NamedQuery(name = "Scrap.findAll", query = "SELECT p FROM Scrap p")})
public class Scrap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ScrapView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ScrapView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(ScrapView.Rate.class)
    @Column(name = "rate")
    private Integer rate;
    @JsonView(ScrapView.ScrapDate.class)
    @Column(name = "scrap_date")
    @Temporal(TemporalType.DATE)
    private Date scrapDate;
    @JsonView(ScrapView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Section section;
    @JsonView(ScrapView.ProductType.class)
    @JoinColumn(name = "Product_Type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType ProductType;
    @JsonView(ScrapView.LossReason.class)
    @JoinColumn(name = "loss_Reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(ScrapView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(ScrapView.OperationType.class)
    @JoinColumn(name = "Operation_Type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationType operationType;

}
