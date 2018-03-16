package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.section.SectionView;

public class LossReasonControlPointCountView {

    public interface Count {
    }
    
    public interface ControlPoint extends ControlPointView.All{
    }

    public interface All extends Count, ControlPoint {
    }

}
