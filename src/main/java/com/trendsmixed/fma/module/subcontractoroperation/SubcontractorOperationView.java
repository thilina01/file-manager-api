package com.trendsmixed.fma.module.subcontractoroperation;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractor.SubcontractorView;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndOperationType;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinition;

/**
 *
 * @author Thilina
 */
public class SubcontractorOperationView {

        public interface Id {
        }

        public interface Subcontractor {
        }

        public interface SubcontractOperationDefinition {
        }

        public interface All extends Id, PageView.All {
        }

        public interface AllAndSubcontractor extends All, Subcontractor, SubcontractorView.All {
        }

        public interface AllAndSubcontractOperationDefinition
                        extends All, SubcontractOperationDefinition, SubcontractOperationDefinitionView.All {
        }

        public static interface AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductType
                        extends All, SubcontractOperationDefinition,
                        SubcontractOperationDefinitionView.AllAndItemAndOperationTypeAndProductType,
                        AllAndOperationType, AllAndProductType, AllAndItemAll {
        }

        public static interface AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor
                        extends All, SubcontractOperationDefinition,
                        SubcontractOperationDefinitionView.AllAndItemAndOperationTypeAndProductType,
                        AllAndOperationType, AllAndProductType, AllAndItemAll, AllAndSubcontractor {
        }

        public interface AllAndSubcontractorAndSubcontractorOperationAndSubcontractOperationDefinition extends All, Subcontractor, AllAndSubcontractorOperationAndSubcontractOperationDefinition {
        }

}
