package com.trendsmixed.fma.module.subcontractoperationdefinition;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.producttype.ProductTypeView;
import com.trendsmixed.fma.module.item.ItemView;

/**
 *
 * @author Thilina
 */
public class SubcontractOperationDefinitionView {

        public interface Id {
        }

        public interface Description {
        }

        public interface Item {
        }

        public interface OperationType {
        }

        public interface ProductType {
        }

        public interface All extends Id, Description, PageView.All {
        }

        public interface AllAndOperationType extends OperationType, OperationTypeView.All {
        }

        public interface AllAndProductType extends ProductType, ProductTypeView.All {
        }

        public static interface AllAndItemAll extends All, Item, ItemView.All {
        }

        public static interface AllAndItemAndOperationTypeAndProductType
                        extends All, AllAndOperationType, AllAndProductType, AllAndItemAll {
        }

}
