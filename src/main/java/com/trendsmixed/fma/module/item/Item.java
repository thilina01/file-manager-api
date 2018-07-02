package com.trendsmixed.fma.module.item;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.itemsegment.ItemSegment;
import com.trendsmixed.fma.module.itemtype.ItemType;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.packagingspecification.PackagingSpecification;
import com.trendsmixed.fma.module.paint.Paint;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinition;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ItemView.Code.class)
    @Column(name = "code", unique = true)
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
    @JsonView(ItemView.ItemSegment.class)
    @JoinColumn(name = "item_segment_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ItemSegment itemSegment;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
    private List<Job> jobList;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "item")
    private List<PackagingSpecification> packagingSpecification;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
    private List<SubcontractOperationDefinition> subcontractOperationDefinition;

    public Item(int anId) {
        this.id = anId;
    }

    @JsonView(ItemView.All.class)
    public String getDisplay() {
        return code + " : " + description;
    }
}
