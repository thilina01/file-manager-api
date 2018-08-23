package com.trendsmixed.fma.module.subcontractreworkoperation;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractreworknote.SubcontractReworkNoteView;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrivalView.AllAndSubcontractOperation;
import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalRejectView;
import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalRejectView.AllAndSubcontractArrival;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndJob;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndSubcontractOperationRate;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView.AllAndSubcontractorOperation;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractOperationDefinition;

/**
 *
 * @author Thilina
 */
public class SubcontractReworkOperationView {

        public interface Id {
        }

        public interface Quantity {
        }

        public interface SubcontractReworkNote {
        }

        public interface SubcontractArrivalReject {
        }

        public interface All extends Id, Quantity, PageView.All {
        }

        public interface AllAndSubcontractArrivalReject
                        extends SubcontractArrivalReject, SubcontractArrivalRejectView.All {
        }

        public interface AllAndSubcontractReworkNote extends SubcontractReworkNote, SubcontractReworkNoteView.All {
        }

        public interface AllAndSubcontractArrivalRejectAndSubcontractReworkNote
                        extends AllAndSubcontractArrivalReject, AllAndSubcontractReworkNote {
        }

        public interface AllAndSubcontractArrivalRejectAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinition
                        extends All, AllAndSubcontractArrivalReject, AllAndSubcontractArrival,
                        AllAndSubcontractOperation, AllAndJob, AllAndSubcontractOperationRate,
                        AllAndSubcontractorOperation, AllAndSubcontractOperationDefinition {
        }
}
