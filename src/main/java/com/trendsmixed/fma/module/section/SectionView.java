package com.trendsmixed.fma.module.section;

import com.trendsmixed.fma.utility.PageView;

public class SectionView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface MTBFTarget {
    }

    public interface MTTRTarget {
    }

    public interface MDTTarget {
    }

    public interface SectionType {
    }

    public interface All extends Id, Code, Name, MTBFTarget, MTTRTarget, MDTTarget, PageView.All {
    }

}
