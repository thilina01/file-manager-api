package com.trendsmixed.fma.module.internaltransferitem;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.producttype.ProductTypeView;
import com.trendsmixed.fma.module.internaltransfernote.InternalTransferNoteView;

/**
 *
 * @author Thilina
 */
public class InternalTransferItemView {

        public interface Id {
        }

        public interface Quantity {
        }

        public interface InternalTransferNote {
        }

        public interface ProductType {
        }

        public interface Job {
        }

        public interface All extends Id, Quantity, PageView.All {
        }

        public interface AllAndJob extends Job, JobView.All {
        }

        public interface AllAndProductType extends ProductType, ProductTypeView.All {
        }

        public interface AllAndInternalTransferNote extends InternalTransferNote, InternalTransferNoteView.All {
        }

        public interface AllAndProductTypeAndJob extends AllAndProductType, AllAndJob {
        }
}
