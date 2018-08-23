package com.trendsmixed.fma.module.drawingchangerequest;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.drawingversion.DrawingVersionView;

/**
 *
 * @author Thilina
 */
public class DrawingChangeRequestView {

        public interface Id {
        }

        public interface Description {
        }

        public interface ChangeRequestDate {
        }

        public interface DrawingVersion {
        }

        public interface All extends Id, Description, ChangeRequestDate, PageView.All {
        }

        public interface AllAndDrawingVersion extends All, DrawingVersion, DrawingVersionView.All {
        }

}
