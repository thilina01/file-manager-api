package com.trendsmixed.fma.jsonView;

public class SectionView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface IdAndCodeAndName extends Id, Code, Name {
    }

}
