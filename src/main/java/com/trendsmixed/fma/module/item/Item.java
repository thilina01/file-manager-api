/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.item;

import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.itemtype.ItemType;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.paint.Paint;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ItemView.Code.class)
    @Column(name = "code",unique=true)
    private String code;
    @JsonView(ItemView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(ItemView.DrawingVersion.class)
    @Column(name = "drawing_version")
    private String drawingVersion;
    @JsonView(ItemView.ProductionToolAvailability.class)
    @Column(name = "production_tool_availability")
    private String productionToolAvailability;
    @JsonView(ItemView.DrawingApproval.class)
    @Column(name = "drawing_approval")
    private String drawingApproval;
    @JsonView(ItemView.Size.class)
    @Column(name = "size")
    private String size;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(ItemView.Volume.class)
    @Column(name = "volume")
    private Double volume;
    @JsonView(ItemView.Weight.class)
    @Column(name = "weight")
    private Double weight;
//    @JsonView(ItemView.SalesOrderItem.class)
//    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
//    private List<SalesOrderItem> salesOrderItemList;
    @JsonView(ItemView.CustomerItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
    private List<CustomerItem> customerItemList;
    @JsonView(ItemView.Paint.class)
    @JoinColumn(name = "paint_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paint paint;
    @JsonView(ItemView.ItemType.class)
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
    private List<Job> jobList;

}
