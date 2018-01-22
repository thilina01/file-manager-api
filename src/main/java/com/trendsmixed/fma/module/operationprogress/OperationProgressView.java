package com.trendsmixed.fma.module.operationprogress;

import com.trendsmixed.fma.module.operation.OperationView;
import com.trendsmixed.fma.utility.PageView;

public class OperationProgressView {

    public interface Id {
    }

    public interface TimeSlot {
    }

    public interface Quantity {
    }

    public interface Operation extends OperationView.All{
    }

    public interface All extends Id, TimeSlot, Quantity, PageView.All {
    }

    public interface AllAndOperation extends All, Operation {
    }

}
