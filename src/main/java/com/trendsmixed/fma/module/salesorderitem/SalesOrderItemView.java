/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.salesorderitem;

import com.trendsmixed.fma.module.item.ItemView;
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

    public static interface Item {
    }

    public static interface Job {
    }

    public static interface SalesOrder {
    }

    public static interface All extends Id, Quantity, Price {
    }

    public static interface AllAndItemAllAndSalesOrderAll extends All, Item, SalesOrder, ItemView.All, SalesOrderView.All {
    }

    public static interface AllAndItemAllAndSalesOrderAllAndJobAll extends AllAndItemAllAndSalesOrderAll, Job, JobView.All {
    }

}
