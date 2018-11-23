package com.trendsmixed.fma.dao;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.CreditNoteItemRowView;
import com.trendsmixed.fma.module.creditnoteitem.CreditNoteItem;

import lombok.Data;

/**
 *
 * @author Thilina
 */
@Data
public class CreditNoteItemRow {
    
    @JsonView(CreditNoteItemRowView.Line1.class)
    private String line1;
    @JsonView(CreditNoteItemRowView.Line2.class)
    private String line2;
    @JsonView(CreditNoteItemRowView.Line3.class)
    private String line3;
    @JsonView(CreditNoteItemRowView.Line4.class)
    private String line4;
    @JsonView(CreditNoteItemRowView.Line5.class)
    private String line5;
    @JsonView(CreditNoteItemRowView.Quantity.class)
    private Double quantity;
    @JsonView(CreditNoteItemRowView.UnitPrice.class)
    private Double unitPrice;
    @JsonView(CreditNoteItemRowView.ItemSize.class)
    private String itemSize;
    @JsonView(CreditNoteItemRowView.ItemWeight.class)
    private Double itemWeight;
    @JsonView(CreditNoteItemRowView.CountryName.class)
    private String countryName;
    @JsonView(CreditNoteItemRowView.CustomerItemCode.class)
    private String customerItemCode;
    @JsonView(CreditNoteItemRowView.CustomerPoNumber.class)
    private String customerPoNumber;
    @JsonView(CreditNoteItemRowView.RejectedQuantity.class)
    private Double rejectedQuantity;
    
    public CreditNoteItemRow(CreditNoteItem creditNoteItem) {
        super();
        if(creditNoteItem != null){
        this.quantity =creditNoteItem.getQuantity()!= null && creditNoteItem.getQuantity()!= null ? creditNoteItem.getQuantity(): 0.0;
        this.unitPrice =creditNoteItem.getUnitPrice()!= null && creditNoteItem.getUnitPrice()!= null ? creditNoteItem.getUnitPrice(): 0.0;
        this.rejectedQuantity =creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getRejectedQuantity()!= null ? creditNoteItem.getLoadingPlanItem().getRejectedQuantity(): 0.0;
        this.line1 = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress()!= null ? creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getLine1(): "NA";
        this.line2 = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress()!= null ? creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getLine2(): "NA";
        this.line3 = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress()!= null ? creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getLine3(): "NA";
        this.line4 = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress()!= null ? creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getLine4(): "NA";
        this.line5 = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress()!= null ? creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getLine5(): "NA";
        this.itemSize = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getJob()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getJob().getItem()!= null ? creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getJob().getItem().getSize(): "NA";
        this.countryName = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress()!= null && creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getCountry()!= null ? creditNoteItem.getLoadingPlanItem().getLoadingPlan().getAddress().getCountry().getName(): "NA";
        this.itemWeight = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getJob()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getJob().getItem()!= null ? creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getJob().getItem().getWeight(): 0.0;
        this.customerItemCode = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem()!= null &&creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem().getCustomerItem() != null ?  creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem().getCustomerItem().getCode(): "NA";
        this.customerPoNumber = creditNoteItem.getLoadingPlanItem()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule()!= null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem()!= null &&creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem() != null && creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem().getSalesOrder()!= null ? creditNoteItem.getLoadingPlanItem().getDispatchSchedule().getSalesOrderItem().getSalesOrder().getCustomerPoNumber(): "NA";

        }
    }   
}
