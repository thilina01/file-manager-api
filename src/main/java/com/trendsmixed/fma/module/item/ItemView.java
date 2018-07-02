package com.trendsmixed.fma.module.item;

import com.trendsmixed.fma.module.itemtype.ItemTypeView;
import com.trendsmixed.fma.module.itemsegment.ItemSegmentView;
import com.trendsmixed.fma.module.paint.PaintView;
import com.trendsmixed.fma.utility.PageView;

public class ItemView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Size {
    }

    public interface Weight {
    }

    public interface Volume {
    }

    public interface Description {
    }

    public interface DrawingVersion {
    }

    public interface DrawingApproval {
    }

    public interface ProductionToolAvailability {
    }

    public interface ItemType {
    }

    public interface Paint {
    }

    public interface ItemMachine {
    }

    public interface SalesOrderItem {
    }

    public interface CustomerItem {
    }

    public interface ItemSegment {
    }

    public interface All extends Id, Code, Size, Weight, Volume, Description, DrawingVersion,
            ProductionToolAvailability, DrawingApproval, PageView.All {
    }

    public interface AllAndItemTypeAll extends All, ItemType, ItemTypeView.All {
    }

    public static interface AllAndPaintAll extends All, Paint, PaintView.All {
    }

    public static interface AllAndItemSegmentAll extends All, ItemSegment, ItemSegmentView.All {
    }

    public static interface AllAndItemTypeAllAndPaintAll extends All, ItemType, ItemTypeView.All, Paint, PaintView.All {
    }

    public static interface AllAndItemTypeAllAndPaintAllAndItemSegmentAll
            extends All, ItemType, ItemTypeView.All, Paint, PaintView.All, ItemSegment, ItemSegmentView.All {
    }

}
