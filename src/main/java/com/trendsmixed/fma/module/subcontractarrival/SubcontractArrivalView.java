package com.trendsmixed.fma.module.subcontractarrival;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndJob;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndSubcontractOperationRate;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndOperationType;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView.AllAndSubcontractorOperation;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractor;
import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalRejectView;

/**
 *
 * @author Thilina
 */
public class SubcontractArrivalView {

        public interface Id {
        }

        public interface ArrivalTime {
        }

        public interface Quantity {
        }

        public interface SubcontractOperation {
        }

        public interface SubcontractArrivalReject {
        }

        public interface All extends Id, ArrivalTime, Quantity, PageView.All {
        }

        public interface AllAndSubcontractOperation extends All, SubcontractOperation, SubcontractOperationView.All {
        }

        public interface AllAndSubcontractArrivalReject
                        extends All, SubcontractArrivalReject, SubcontractArrivalRejectView.All {
        }

        public interface AllAndSubcontractOperationAndSubcontractNote
                        extends All, SubcontractOperation, SubcontractOperationView.AllAndSubcontractNote {
        }

        public interface AllAndSubcontractOperationAndSubcontractNoteAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndItemAndProductTypeAndOperationType
                        extends All, SubcontractOperation, SubcontractOperationView.AllAndSubcontractNote, AllAndJob,
                        AllAndSubcontractOperationRate, AllAndSubcontractorOperation,
                        AllAndSubcontractOperationDefinition, AllAndSubcontractor, AllAndItemAll, AllAndProductType,
                        AllAndOperationType {
        }

}
