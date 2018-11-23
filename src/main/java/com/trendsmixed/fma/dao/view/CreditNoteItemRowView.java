package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.creditnoteitem.CreditNoteItemView;

public class CreditNoteItemRowView {

    public interface Line1 {
    }

    public interface Line2 {
    }

    public interface Line3 {
    }

    public interface Line4 {
    }

    public interface Line5 {
    }

    public interface ItemSize {
    }

    public interface Quantity {
    }

    public interface UnitPrice {
    }

    public interface ItemWeight {
    }

    public interface CountryName {
    }

    public interface CustomerItemCode {
    }

    public interface CustomerPoNumber {
    }

    public interface RejectedQuantity {
    }

    public interface CreditNoteItem extends CreditNoteItemView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
    }

    public interface All extends Line1, Line2, Line3, Line4, Line5, ItemSize, ItemWeight, CountryName, CustomerItemCode,
            CustomerPoNumber, Quantity, UnitPrice, RejectedQuantity,CreditNoteItemView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
    }

}
