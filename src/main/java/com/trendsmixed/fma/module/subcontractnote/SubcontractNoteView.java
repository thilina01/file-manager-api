package com.trendsmixed.fma.module.subcontractnote;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractor.SubcontractorView;
import com.trendsmixed.fma.module.location.LocationView;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView.AllAndSubcontractorOperation;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperationView.AllAndJobAndSubcontractOperationRateAndSubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndOperationType;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;

/**
 *
 * @author Thilina
 */
public class SubcontractNoteView {

        public interface Id {
        }

        public interface NoteTime {
        }

        public interface Subcontractor {
        }

        public interface SubcontractOperation {
        }

        public interface VehicleNumber {
        }

        public interface Recipient {
        }

        public interface SubcontractReleaseTime {
        }

        public interface ContainerNumber {
        }

        public interface Location {
        }

        public interface All extends Id, NoteTime, VehicleNumber, Recipient, SubcontractReleaseTime, ContainerNumber,
                        Location, PageView.All {
        }

        public interface AllAndSubcontractor extends All, Subcontractor, SubcontractorView.All {
        }

        public interface AllAndSubcontractOperation extends All, SubcontractOperation, SubcontractOperationView.All {
        }

        public interface AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractor
                        extends All, SubcontractOperation,
                        AllAndJobAndSubcontractOperationRateAndSubcontractOperationDefinition,
                        AllAndSubcontractorOperation, AllAndSubcontractOperationDefinition, AllAndSubcontractor {
        }

        public interface AllAndLocation extends All, Location, LocationView.All {
        }

        public interface AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndLocation
                        extends All, SubcontractOperation,
                        AllAndJobAndSubcontractOperationRateAndSubcontractOperationDefinition,
                        AllAndSubcontractorOperation, AllAndSubcontractOperationDefinition, AllAndSubcontractor,
                        AllAndLocation {
        }

        public interface AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndItemAndOperationTypeAndProductType
                        extends All, SubcontractOperation,
                        AllAndJobAndSubcontractOperationRateAndSubcontractOperationDefinition,
                        AllAndSubcontractorOperation, AllAndSubcontractOperationDefinition, AllAndSubcontractor,
                        AllAndOperationType, AllAndProductType, AllAndItemAll {
        }

}
