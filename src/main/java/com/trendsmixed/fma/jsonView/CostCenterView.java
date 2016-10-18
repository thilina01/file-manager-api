package com.trendsmixed.fma.jsonView;

public class CostCenterView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface IdAndCodeAndName extends Id, Code, Name {
    }

    public static interface IdAndCodeAndNameAndSectionId extends IdAndCodeAndName, SectionView.Id {
    }
}
