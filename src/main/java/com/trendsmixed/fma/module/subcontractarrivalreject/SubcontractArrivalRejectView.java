package com.trendsmixed.fma.module.subcontractarrivalreject;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrivalView;

/**
 *
 * @author Thilina
 */
public class SubcontractArrivalRejectView {

        public interface Id {
        }

        public interface LossReason {
        }

        public interface Quantity {
        }

        public interface SubcontractArrival {
        }

        public interface All extends Id, Quantity, PageView.All {
        }

        public interface AllAndSubcontractArrival extends All, SubcontractArrival, SubcontractArrivalView.All {
        }

        public interface AllAndLossReason extends All, LossReason, LossReasonView.All {
        }

        public interface AllAndLossReasonAndSubcontractArrival extends All, AllAndSubcontractArrival, AllAndLossReason {
        }

}
