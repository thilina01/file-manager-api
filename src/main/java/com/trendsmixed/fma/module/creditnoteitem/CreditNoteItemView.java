package com.trendsmixed.fma.module.creditnoteitem;

import com.trendsmixed.fma.module.creditnote.CreditNoteView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndLoadingPlan;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndPackagingSpecificationAndPalletSize;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class CreditNoteItemView {

        public interface Id {
        }

        public interface Quantity {
        }

        public interface UnitPrice {
        }

        public interface ItemDescription {
        }

        public interface ItemCode {
        }

        public interface CreditNote {
        }

        public interface LoadingPlanItem {
        }

        public interface All extends Id, UnitPrice, Quantity, ItemCode, ItemDescription, PageView.All {
        }

        public interface AllAndCreditNote extends All, CreditNote, CreditNoteView.All {
        }

        public interface AllAndLoadingPlanItem extends All, LoadingPlanItem, LoadingPlanItemView.All {
        }

        public interface AllAndLoadingPlanItemAndLoadingPlan extends All, AllAndLoadingPlan {
        }

        public interface AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSize
                        extends All, LoadingPlanItem,
                        LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecificationAndPalletSize {
        }

}
