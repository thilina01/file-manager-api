package com.trendsmixed.fma.module.item;

import com.trendsmixed.fma.module.itemtype.ItemTypeView;
import com.trendsmixed.fma.module.paint.PaintView;
import com.trendsmixed.fma.utility.PageView;

public class ItemView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Size {
    }

    public static interface Weight {
    }

    public static interface Volume {
    }

    public static interface Description {
    }

    public static interface DrawingVersion {
    }

    public static interface DrawingApproval {
    }

    public static interface ProductionToolAvailability {
    }

    public static interface ItemType {
    }

    public static interface Paint {
    }

    public static interface ItemMachine {
    }

    public static interface SalesOrderItem {
    }

    public static interface CustomerItem {
    }

    public static interface All extends Id, Code, Size, Weight, Volume, Description, DrawingVersion, ProductionToolAvailability, DrawingApproval, PageView.All {
    }

    public static interface AllAndItemTypeAll extends All, ItemType, ItemTypeView.All {
    }

    public static interface AllAndPaintAll extends All, Paint, PaintView.All {
    }

    public static interface AllAndItemTypeAllAndPaintAll extends All, ItemType, ItemTypeView.All, Paint, PaintView.All {
    }
    
}
