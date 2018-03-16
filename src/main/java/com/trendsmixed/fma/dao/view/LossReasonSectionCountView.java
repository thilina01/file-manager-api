package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.section.SectionView;

public class LossReasonSectionCountView {

    public interface Count {
    }
    
    public interface Section extends SectionView.All{
    }

    public interface All extends Count, Section {
    }

}
