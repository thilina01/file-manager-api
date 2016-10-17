/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "product_type_id")
    private int ItemTypeId;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "volume")
    private String volume;
    @Column(name = "production_tool_availablity")
    private String productionToolAvailablity;
    @Column(name = "description")
    private String description;
    @Column(name = "drawing_version")
    private String drawingVersion;
    @ManyToMany(mappedBy = "itemCollection")
    private Collection<CustomerItem> customerItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<PurchaseOrderHasItem> purchaseOrderHasItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<ItemHasMachine> itemHasMachineCollection;
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemType;
    @JoinColumn(name = "paint_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paint paint;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, int ItemTypeId) {
        this.id = id;
        this.ItemTypeId = ItemTypeId;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getItemTypeId() {
        return ItemTypeId;
    }

    public void setItemTypeId(int ItemTypeId) {
        this.ItemTypeId = ItemTypeId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getProductionToolAvailablity() {
        return productionToolAvailablity;
    }

    public void setProductionToolAvailablity(String productionToolAvailablity) {
        this.productionToolAvailablity = productionToolAvailablity;
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

    public Collection<CustomerItem> getCustomerItemCollection() {
        return customerItemCollection;
    }

    public void setCustomerItemCollection(Collection<CustomerItem> customerItemCollection) {
        this.customerItemCollection = customerItemCollection;
    }

    public Collection<PurchaseOrderHasItem> getPurchaseOrderHasItemCollection() {
        return purchaseOrderHasItemCollection;
    }

    public void setPurchaseOrderHasItemCollection(Collection<PurchaseOrderHasItem> purchaseOrderHasItemCollection) {
        this.purchaseOrderHasItemCollection = purchaseOrderHasItemCollection;
    }

    public Collection<ItemHasMachine> getItemHasMachineCollection() {
        return itemHasMachineCollection;
    }

    public void setItemHasMachineCollection(Collection<ItemHasMachine> itemHasMachineCollection) {
        this.itemHasMachineCollection = itemHasMachineCollection;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
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
