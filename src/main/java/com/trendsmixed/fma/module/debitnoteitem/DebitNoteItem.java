package com.trendsmixed.fma.module.debitnoteitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "debit_note_item")
public class DebitNoteItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(DebitNoteItemView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(DebitNoteItemView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(DebitNoteItemView.UnitPrice.class)
    @Column(name = "unit_price")
    private Double unitPrice;
    @JsonView(DebitNoteItemView.ItemDescription.class)
    @Column(name = "item_description")
    private String itemDescription;
    @JsonView(DebitNoteItemView.ItemCode.class)
    @Column(name = "item_code")
    private String itemCode;
    @JsonView(DebitNoteItemView.LoadingPlanItem.class)
    @JoinColumn(name = "loading_plan_item_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private LoadingPlanItem loadingPlanItem;

    @JsonView(DebitNoteItemView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
