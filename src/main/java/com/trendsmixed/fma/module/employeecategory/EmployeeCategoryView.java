package com.trendsmixed.fma.module.employeecategory;

import com.trendsmixed.fma.utility.PageView;

public class EmployeeCategoryView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
