package com.trendsmixed.fma.module.subcontractarrivalreject;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrivalView;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrivalView.AllAndSubcontractOperation;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndJob;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndSubcontractOperationRate;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndOperationType;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView.AllAndSubcontractorOperation;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractor;

/**
 *
 * @author Thilina
 */
public class SubcontractArrivalRejectView {

        public interface Id {
        }

        public interface Quantity {
        }

        public interface LossReason {
        }

        public interface ArrivalRejectDate {
        }

        public interface SubcontractArrival {
        }

        public interface All extends Id, Quantity, ArrivalRejectDate, PageView.All {
        }

        public interface AllAndSubcontractArrival extends All, SubcontractArrival, SubcontractArrivalView.All {
        }

        public interface AllAndLossReason extends All, LossReason, LossReasonView.All {
        }

        public interface AllAndLossReasonAndSubcontractArrival extends All, AllAndSubcontractArrival, AllAndLossReason {
        }

        public interface AllAndLossReasonAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractorAndSubcontractOperationDefinitionAndItemAndProductTypeAndOperationType
                        extends All, AllAndSubcontractArrival, AllAndSubcontractOperation,
                        AllAndSubcontractOperationRate, AllAndSubcontractorOperation, AllAndSubcontractor,
                        AllAndLossReason, AllAndSubcontractOperationDefinition, AllAndJob, AllAndItemAll,
                        AllAndProductType, AllAndOperationType {
        }

}
