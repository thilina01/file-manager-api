package com.trendsmixed.fma.module.location;

import com.trendsmixed.fma.utility.PageView;

public class LocationView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Address {
    }

    public interface DispatchNote {
    }

    public interface All extends Id, Code, Name,Address, PageView.All {

    }

}
