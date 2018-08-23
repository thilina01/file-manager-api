package com.trendsmixed.fma.module.subcontractreworknote;

import com.trendsmixed.fma.utility.PageView;

import com.trendsmixed.fma.module.location.LocationView;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrivalView.AllAndSubcontractOperation;
import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalRejectView.AllAndSubcontractArrival;
import com.trendsmixed.fma.module.subcontractor.SubcontractorView;
import com.trendsmixed.fma.module.subcontractreworkoperation.SubcontractReworkOperationView;
import com.trendsmixed.fma.module.subcontractreworkoperation.SubcontractReworkOperationView.AllAndSubcontractArrivalReject;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndJob;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndSubcontractOperationRate;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView.AllAndSubcontractorOperation;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractOperationDefinition;

/**
 *
 * @author Thilina
 */
public class SubcontractReworkNoteView {

        public interface Id {
        }

        public interface NoteTime {
        }

        public interface VehicleNumber {
        }

        public interface Recipient {
        }

        public interface SubcontractReleaseTime {
        }

        public interface ContainerNumber {
        }

        public interface Subcontractor {
        }

        public interface SubcontractReworkOperation {
        }

        public interface Location {
        }

        public interface All extends Id, NoteTime, Recipient, VehicleNumber, SubcontractReleaseTime, ContainerNumber,
                        PageView.All {
        }

        public interface AllAndLocation extends All, Location, LocationView.All {
        }

        public interface AllAndSubcontractor extends All, Subcontractor, SubcontractorView.All {
        }

        public interface AllAndSubcontractReworkOperation
                        extends All, SubcontractReworkOperation, SubcontractReworkOperationView.All {
        }

        public interface AllAndAllAndSubcontractArrivalRejectAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndProductTypeAndItemAndSubcontractorAndLocation
                        extends All, AllAndSubcontractReworkOperation, AllAndSubcontractor, AllAndLocation,
                        AllAndSubcontractArrivalReject, AllAndSubcontractArrival, AllAndSubcontractOperation, AllAndJob,
                        AllAndItemAll, AllAndProductType, AllAndSubcontractOperationRate, AllAndSubcontractorOperation,
                        AllAndSubcontractOperationDefinition {
        }

}
