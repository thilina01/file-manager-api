package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.job.JobView;

public class InvoiceInformationView {

    public interface InvoiceNumber {
    }

    public interface InvoiceDate {
    }

    public interface CustomerCode {
    }

    public interface CustomerName {
    }

    public interface CustomerItemCode {
    }

    public interface CustomerPoNumber {
    }

    public interface ItemCode {
    }

    public interface Description {
    }

    public interface JobNo {
    }

    public interface Weight {
    }

    public interface UnitPrice {
    }

    public interface Quantity {
    }

    public interface RejectedQuantity {
    }

    public interface Customer extends CustomerView.All {
    }

    public interface Job extends JobView.All {
    }

    public interface All
            extends Customer, Job, InvoiceNumber, InvoiceDate, CustomerCode, CustomerName, CustomerItemCode,
            CustomerPoNumber, ItemCode, Description, JobNo, Weight, UnitPrice, Quantity, RejectedQuantity {
    }

}
