package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class CostCenterView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Section {
    }

    public interface WorkCenter extends WorkCenterView.All {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface AllAndSectionId extends All, Section, SectionView.Id {
    }

    public interface AllAndSectionAll extends All, Section, SectionView.All {
    }

    public interface AllAndWorkCenter extends All, WorkCenter {
    }

}
