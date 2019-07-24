package com.trendsmixed.fma.module.internaltransferitem;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.job.JobView.AllAndItemAll;
import com.trendsmixed.fma.module.producttype.ProductTypeView;
import com.trendsmixed.fma.module.internaltransfernote.InternalTransferNoteView;
import com.trendsmixed.fma.module.internaltransfernote.InternalTransferNoteView.AllAndFromLocation;
import com.trendsmixed.fma.module.internaltransfernote.InternalTransferNoteView.AllAndToLocation;

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

        public interface AllAndProductTypeAndJobAndItem extends AllAndProductType, AllAndJob, AllAndItemAll {
        }

        public interface AllAndFromLocationAndToLocation extends All, InternalTransferNote,
                        InternalTransferNoteView.AllAndFromLocation, AllAndToLocation {
        }

        public interface AllAndProductTypeAndJobAndItemAndInternalTransferNoteAndFromLocationAndToLocation extends All,
                        AllAndProductType, AllAndJob, AllAndItemAll, InternalTransferNote, AllAndFromLocation,AllAndToLocation {
        }

}
