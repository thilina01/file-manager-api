package com.trendsmixed.fma.module.subcontractarrival;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView;
import com.trendsmixed.fma.module.location.LocationView;

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

        public interface All extends Id, ArrivalTime, Quantity, PageView.All {
        }

        public interface AllAndSubcontractOperation extends All, SubcontractOperation, SubcontractOperationView.All {
        }

        public interface AllAndSubcontractOperationAndSubcontractNote
                        extends All, SubcontractOperation, SubcontractOperationView.AllAndSubcontractNote {
        }

}
