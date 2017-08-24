/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.salesorderitem;

import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.salesorder.SalesOrderView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SalesOrderItemView {

    public static interface Id {
    }

    public static interface Quantity {
    }
    
    public static interface Scheduled {
    }

    public static interface UnitPrice {
    }

    public static interface Amount {
    }

    public static interface CustomerItem extends CustomerItemView.All {
    }

    public static interface Job extends JobView.All {
    }

    public static interface SalesOrder extends SalesOrderView.All {
    }

    public static interface All extends Id, Quantity, Scheduled, UnitPrice, Amount, PageView.All {
    }

    public static interface AllAndCustomerItemAll extends All, CustomerItem {
    }

    public static interface AllAndCustomerItemAllAndSalesOrderAll extends AllAndCustomerItemAll, SalesOrder {
    }

    public static interface AllAndCustomerItemAllAndSalesOrderAllAndJobAll extends AllAndCustomerItemAllAndSalesOrderAll, Job {
    }

    public static interface AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndJobAll extends AllAndCustomerItemAllAndSalesOrderAll, Job, CustomerItemView.AllAndItemAll {
    }

    public static interface AllAndCustomerItemAllAndItemAllAndJobAll extends AllAndCustomerItemAll, Job, CustomerItemView.AllAndItemAll {
    }

}
