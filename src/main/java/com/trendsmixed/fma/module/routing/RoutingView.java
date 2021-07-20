package com.trendsmixed.fma.module.routing;

import com.trendsmixed.fma.utility.PageView;

public class RoutingView {

    public interface Id {
    }

    public interface Sequence {
    }

    public interface PerShiftCapacity {
    }

    public interface ManMinutes {
    }

    public interface HeadCount {
    }

    public interface Description {
    }

    public interface Item {
    }

    public interface ControlPoint {
    }

    public interface MaterialType {
    }

    public interface Skill {
    }

    public interface OperationType {
    }

    public interface All extends Id, Sequence, PerShiftCapacity, HeadCount, ManMinutes, PageView.All {
    }

}
