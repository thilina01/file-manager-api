package com.trendsmixed.fma.module.subcontractoperationrate;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndItemAll;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndOperationType;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinitionView.AllAndProductType;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.AllAndSubcontractor;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView.Subcontractor;

/**
 *
 * @author Thilina
 */
public class SubcontractOperationRateView {

        public interface Id {
        }

        public interface DateOfRate {
        }

        public interface Rate {
        }

        public interface SubcontractorOperation {
        }

        public interface SubcontractOperation {
        }

        public interface All extends Id, DateOfRate, Rate, PageView.All {
        }

        public interface AllAndSubcontractorOperation
                        extends All, SubcontractorOperation, SubcontractorOperationView.All {
        }

        public interface AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor
                        extends All, SubcontractorOperation,
                        SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor,
                        AllAndOperationType, AllAndProductType, AllAndItemAll, AllAndSubcontractor {
        }

        public interface AllAndSubcontractorOperationAndSubcontractOperationDefinition extends All,
                        SubcontractorOperation, SubcontractorOperationView.AllAndSubcontractOperationDefinition {
        }

        public interface AllAndSubcontractorAndSubcontractorOperationAndSubcontractOperationDefinition extends All, Subcontractor, AllAndSubcontractorOperationAndSubcontractOperationDefinition {
        }

}
