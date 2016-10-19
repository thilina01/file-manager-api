package com.trendsmixed.fma.jsonView;

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

    public static interface ProductionToolAvailability {
    }

    public static interface All extends Id, Code, Size, Weight, Volume, Description, DrawingVersion, ProductionToolAvailability {
    }

    public static interface ItemType {
    }

    public static interface AllAndItemTypeAll extends All, ItemType, ItemTypeView.AlL {
    }

    public static interface Paint {
    }
    
    public static interface AllAndPaintAll extends All, Paint, PaintView.All {
    }
    
    public static interface AllAndItemTypeAllAndPaintAll extends All, ItemType, ItemTypeView.AlL,Paint,PaintView.All {
    }

}
