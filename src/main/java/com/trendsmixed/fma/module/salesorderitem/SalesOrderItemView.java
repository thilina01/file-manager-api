/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.salesorderitem;

import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.salesorder.SalesOrderView;

/**
 *
 * @author Daminda
 */
public class SalesOrderItemView {

    public static interface Id {
    }

    public static interface Quantity {
    }

    public static interface Price {
    }

    public static interface CustomerItem {
    }

    public static interface Job {
    }

    public static interface SalesOrder {
    }

    public static interface All extends Id, Quantity, Price {
    }

    public static interface AllAndCustomerItemAllAndSalesOrderAll extends All, CustomerItem, SalesOrder, CustomerItemView.All, SalesOrderView.All {
    }

    public static interface AllAndItemAllAndSalesOrderAllAndJobAll extends AllAndCustomerItemAllAndSalesOrderAll, Job, JobView.All {
    }

}
