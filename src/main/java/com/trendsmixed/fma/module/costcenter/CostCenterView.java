package com.trendsmixed.fma.module.costcenter;

import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.utility.PageView;

public class CostCenterView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface Section {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface AllAndSectionId extends All, Section, SectionView.Id {
    }

    public static interface AllAndSectionAll extends All, Section, SectionView.All {
    }
}
