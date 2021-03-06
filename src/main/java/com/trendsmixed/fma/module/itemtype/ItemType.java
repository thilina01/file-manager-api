package com.trendsmixed.fma.module.itemtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(of = {"id"})
@Table(name = "item_type")
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ItemTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ItemTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ItemTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "itemType")
    private List<Item> itemList;

    public ItemType(int anId) {
        this.id = anId;
    }

    @JsonView(ItemTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
