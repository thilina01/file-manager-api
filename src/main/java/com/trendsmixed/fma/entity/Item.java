/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ItemView;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
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
    @Column(name = "code")
    private String code;
    @JsonView(ItemView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(ItemView.DrawingVersion.class)
    @Column(name = "drawing_version")
    private String drawingVersion;
    @Basic(optional = false)
    @JsonView(ItemView.ProductionToolAvailability.class)
    @Column(name = "production_tool_availablity")
    private String productionToolAvailablity;
    @JsonView(ItemView.Size.class)
    @Column(name = "size")
    private String size;
    @JsonView(ItemView.Volume.class)
    @Column(name = "volume")
    private double volume;
    @JsonView(ItemView.Weight.class)
    @Column(name = "weight")
    private double weight;
    @JoinTable(name = "item_has_customer_item", joinColumns = {
        @JoinColumn(name = "item_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "customer_item_id", referencedColumnName = "id")})
    @ManyToMany
    private List<CustomerItem> customerItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<PurchaseOrderHasItem> purchaseOrderHasItemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<ItemHasMachine> itemHasMachineList;
    @JsonView(ItemView.Paint.class)
    @JoinColumn(name = "paint_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paint paint;
    @JsonView(ItemView.ItemType.class)
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemType;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDrawingVersion() {
        return drawingVersion;
    }

    public void setDrawingVersion(String drawingVersion) {
        this.drawingVersion = drawingVersion;
    }

    public String getProductionToolAvailablity() {
        return productionToolAvailablity;
    }

    public void setProductionToolAvailablity(String productionToolAvailablity) {
        this.productionToolAvailablity = productionToolAvailablity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<CustomerItem> getCustomerItemList() {
        return customerItemList;
    }

    public void setCustomerItemList(List<CustomerItem> customerItemList) {
        this.customerItemList = customerItemList;
    }

    public List<PurchaseOrderHasItem> getPurchaseOrderHasItemList() {
        return purchaseOrderHasItemList;
    }

    public void setPurchaseOrderHasItemList(List<PurchaseOrderHasItem> purchaseOrderHasItemList) {
        this.purchaseOrderHasItemList = purchaseOrderHasItemList;
    }

    public List<ItemHasMachine> getItemHasMachineList() {
        return itemHasMachineList;
    }

    public void setItemHasMachineList(List<ItemHasMachine> itemHasMachineList) {
        this.itemHasMachineList = itemHasMachineList;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Item[ id=" + id + " ]";
    }

}
