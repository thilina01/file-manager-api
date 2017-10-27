package com.trendsmixed.fma.module.leavetype;

import com.trendsmixed.fma.utility.PageView;

public class LeaveTypeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface TypeInSinhala {
    }

    public interface All extends Id, Name, Code, TypeInSinhala, PageView.All {
    }

}
