package com.trendsmixed.fma.module.debitnoteitem;

import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView;
import com.trendsmixed.fma.module.debitnote.DebitNoteView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class DebitNoteItemView {

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

        public interface LoadingPlanItem {
        }

        public interface DebitNote {
        }

        public interface All extends Id, UnitPrice, Quantity, ItemCode, ItemDescription, PageView.All {
        }

        public interface AllAndLoadingPlanItem extends All, LoadingPlanItem, LoadingPlanItemView.All {
        }

        public interface AllAndDebitNote extends All, DebitNote, DebitNoteView.All {
        }

}
