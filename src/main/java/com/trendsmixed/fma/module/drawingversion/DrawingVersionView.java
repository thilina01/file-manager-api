package com.trendsmixed.fma.module.drawingversion;

import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.drawingchangerequest.DrawingChangeRequestView;
import com.trendsmixed.fma.utility.PageView;

public class DrawingVersionView {

    public interface Id {
    }

    public interface Version {
    }

    public interface Description {
    }

    public interface FilePath {
    }

    public interface Item {
    }

    public interface DrawingChangeRequest {
    }

    public interface All extends Id, Version, FilePath, Description, PageView.All {
    }

    public interface AllAndItem extends All, Item, ItemView.All {
    }

    public interface AllAndDrawingChangeRequest extends All, DrawingChangeRequest, DrawingChangeRequestView.All {
    }

    public interface AllAndDrawingChangeRequestAndItem extends All, AllAndItem, AllAndDrawingChangeRequest {
    }

}
