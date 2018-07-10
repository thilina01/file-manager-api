package com.trendsmixed.fma.module.internaltransfernote;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.location.LocationView;
import com.trendsmixed.fma.module.internaltransferitem.InternalTransferItemView;
import com.trendsmixed.fma.module.internaltransferitem.InternalTransferItemView.AllAndJob;
import com.trendsmixed.fma.module.internaltransferitem.InternalTransferItemView.AllAndProductType;
import com.trendsmixed.fma.module.job.JobView.AllAndItemAll;

/**
 *
 * @author Thilina
 */
public class InternalTransferNoteView {

        public interface Id {
        }

        public interface ArrivalTime {
        }

        public interface VehicleNumber {
        }

        public interface Recipient {
        }

        public interface Description {
        }

        public interface ReleaseTime {
        }

        public interface Location {
        }

        public interface NoteDate {
        }

        public interface FromLocation {
        }

        public interface InternalTransferItem {
        }

        public interface ToLocation {
        }

        public interface All extends Id, ArrivalTime, VehicleNumber, Recipient, ReleaseTime, Description, NoteDate,
                        PageView.All {
        }

        public interface AllAndToLocation extends All, ToLocation, LocationView.All {
        }

        public interface AllAndFromLocation extends All, FromLocation, LocationView.All {
        }

        public interface AllAndInternalTransferItem extends All, InternalTransferItem, InternalTransferItemView.All {
        }

        public interface AllAndProductTypeAndJob extends All, InternalTransferItem,
                        InternalTransferItemView.AllAndProductTypeAndJob, AllAndProductType, AllAndJob {
        }

        public interface AllAndFromLocationAndToLocation extends All, AllAndFromLocation, AllAndToLocation {
        }

        public interface AllAndFromLocationAndToLocationAndInternalTransferItemAndProductTypeAndJobAndItem
                        extends All, AllAndFromLocationAndToLocation, AllAndInternalTransferItem,
                        InternalTransferItemView.AllAndProductTypeAndJob, AllAndProductType, AllAndJob, AllAndItemAll {
        }

}
