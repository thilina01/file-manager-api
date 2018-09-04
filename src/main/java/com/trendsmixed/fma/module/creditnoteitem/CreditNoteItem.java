package com.trendsmixed.fma.module.creditnoteitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.creditnote.CreditNote;
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
@Table(name = "credit_note_item")
public class CreditNoteItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(CreditNoteItemView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(CreditNoteItemView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(CreditNoteItemView.UnitPrice.class)
    @Column(name = "unit_price")
    private Double unitPrice;
    @JsonView(CreditNoteItemView.ItemDescription.class)
    @Column(name = "item_description")
    private String itemDescription;
    @JsonView(CreditNoteItemView.ItemCode.class)
    @Column(name = "item_code")
    private String itemCode;
    @JsonView(CreditNoteItemView.CreditNote.class)
    @JoinColumn(name = "credit_note_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private CreditNote creditNote;
    @JsonView(CreditNoteItemView.LoadingPlanItem.class)
    @JoinColumn(name = "loading_plan_item_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private LoadingPlanItem loadingPlanItem;

    @JsonView(CreditNoteItemView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
