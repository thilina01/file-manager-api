package com.trendsmixed.fma.module.subcontractoperation;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrivalView;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNoteView;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndOperationType;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractOperationDefinition;
import com.trendsmixed.fma.module.job.JobView;

/**
 *
 * @author Thilina
 */
public class SubcontractOperationView {

        public interface Id {
        }

        public interface Quantity {
        }

        public interface SubcontractOperationRate {
        }

        public interface SubcontractNote {
        }

        public interface SubcontractArrival {
        }

        public interface Job {
        }

        public interface All extends Id, Quantity, PageView.All {
        }

        public interface AllAndSubcontractNote extends All, SubcontractNote, SubcontractNoteView.All {
        }

        public interface AllAndSubcontractArrival extends All, SubcontractArrival, SubcontractArrivalView.All {
        }

        public interface AllAndSubcontractOperationRate
                        extends SubcontractOperationRate, SubcontractOperationRateView.All {
        }

        public interface AllAndJob extends Job, JobView.All {
        }

        public interface AllAndSubcontractNoteAndJobAndSubcontractOperationRate
                        extends All, AllAndSubcontractNote, AllAndSubcontractOperationRate, AllAndJob {
        }

        public interface AllAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductType
                        extends SubcontractOperationRate,
                        SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor,
                        AllAndOperationType, AllAndProductType, AllAndItemAll {
        }

        public interface AllAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractNoteAndJobAndSubcontractOperationRate
                        extends SubcontractOperationRate,
                        SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor,
                        AllAndOperationType, AllAndProductType, AllAndItemAll, AllAndSubcontractNote,
                        AllAndSubcontractOperationRate, AllAndJob {
        }

        public interface AllAndJobAndSubcontractOperationRateAndSubcontractOperationDefinition
                        extends All, AllAndSubcontractOperationRate, AllAndJob, AllAndSubcontractOperationDefinition {
        }

        public interface AllJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductType
                        extends All, SubcontractOperationRate,
                        SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor,
                        AllAndOperationType, AllAndProductType, AllAndItemAll, AllAndJob {
        }
        public interface AllJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractArrival
                        extends All, SubcontractOperationRate,
                        SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor,
                        AllAndOperationType, AllAndProductType, AllAndItemAll, AllAndJob,AllAndSubcontractArrival {
        }

}
