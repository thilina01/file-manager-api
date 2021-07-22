package com.trendsmixed.fma.module.salesorder;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemService;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesOrders")
public class SalesOrderController {


    private final SalesOrderService service;
    private final SalesOrderItemService salesOrderItemService;
    private final JobTypeService jobTypeService;
    private final CustomerService customerService;

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping
    public Iterable<SalesOrder> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping("/page")
    Page<SalesOrder> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/salesOrderDurationPage", params = {"startDate", "endDate"})
    public Page<SalesOrder> salesOrderDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByOrderDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/orderDateAndSalesOrderTypePage", params = {"orderDate", "salesOrderType"})
    public Page<SalesOrder> orderDateAndSalesOrderTypePage(@RequestParam("orderDate") String orderDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByOrderDateAndSalesOrderType(Format.yyyy_MM_dd.parse(orderDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/salesOrderDurationAndSalesOrderTypePage", params = {"startDate", "endDate", "salesOrderType"})
    public Page<SalesOrder> salesOrderDurationAndSalesOrderTypePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByOrderDateBetweenAndSalesOrderType(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerAndSalesOrderDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<SalesOrder> customerAndSalesOrderDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerAndOrderDateAndSalesOrderTypePage", params = {"customer", "orderDate", "salesOrderType"})
    public Page<SalesOrder> customerAndOrderDateAndSalesOrderTypePage(@RequestParam("customer") String customer, @RequestParam("orderDate") String orderDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndOrderDateAndSalesOrderType(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(orderDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerAndSalesOrderDurationAndSalesOrderTypePage", params = {"customer", "startDate", "endDate", "salesOrderType"})
    public Page<SalesOrder> customerAndSalesOrderDurationAndSalesOrderTypePage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndOrderDateBetweenAndSalesOrderType(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }

/*     @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerPONumberPage", params = {"customerPoNumber","startDate", "endDate"})
    public Page<SalesOrder> customerPoNumberPage(@RequestParam("customerPoNumber") String customerPoNumber,@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerPoNumber(new SalesOrder(Integer.valueOf(customerPoNumber)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
 */
    // @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    // @GetMapping("/customerPoNumber/{id}")
    // public Iterable<SalesOrder> findByCustomerPoNumber(@PathVariable("customerPoNumber") int customerPoNumber) {
    //     return service.findByCustomerPoNumber(new SalesOrder(customerPoNumber));
    // }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/salesOrder")
    public Page<SalesOrderItem> getSalesOrder(
            @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
            @RequestParam(value = "salesOrderType", required = false, defaultValue = "0") String salesOrderType,
            @RequestParam(value = "customerPoNumber", required = false, defaultValue = "0") String customerPoNumber,
            @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
            @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate,
            Pageable pageable) throws ParseException {
        Page<SalesOrderItem> page;
        if (!customerPoNumber.equals("0")) {
            page = new Page(service.findByCustomerPoNumber(customerPoNumber, pageable));
        } else if (!customer.equals("0") && !salesOrderType.equals("0")) {
            page = new Page(service.findByCustomerAndOrderDateBetweenAndSalesOrderType(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
        } else if (!customer.equals("0")) {
            page = new Page(service.findByCustomerAndOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } else if (!salesOrderType.equals("0")) {
            page = new Page(service.findByOrderDateBetweenAndSalesOrderType(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
        } else {
            page = new Page(service.findByOrderDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PostMapping("/pageByCustomer")
    Page<SalesOrder> pageByCustomer(Pageable pageable, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return new Page<>(service.findByCustomer(customer, pageable));
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @GetMapping("/comboByCustomer/{id}")
    List<Combo> combo(@PathVariable("id") int id) {
        return service.getComboByCustomer(new Customer(id));
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PostMapping
    public SalesOrder save(@RequestBody SalesOrder salesOrder) {
        try {
            List<SalesOrderItem> salesOrderItems = salesOrder.getSalesOrderItemList();
            if (salesOrderItems != null) {
                for (SalesOrderItem salesOrderItem : salesOrderItems) {
                    if (salesOrderItem.getId() != null) {
                        SalesOrderItem existingSalesOrderItem = salesOrderItemService.findById(salesOrderItem.getId());
                        salesOrderItem.setDispatchScheduleList(existingSalesOrderItem != null ? existingSalesOrderItem.getDispatchScheduleList() : new ArrayList<>());
                    }
                    salesOrderItem.setSalesOrder(salesOrder);
                }
            }
            salesOrder = service.save(salesOrder);
            return salesOrder;
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAllAndItemAllAndDispatchScheduleAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoice.class)
    @GetMapping("/{id}")
    public SalesOrder findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.deleteById(id);

    }

    @LogExecution
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PutMapping("/{id}")
    public SalesOrder updateCustomer(@PathVariable int id, @RequestBody SalesOrder salesOrder) {

        salesOrder.setId(id);
        salesOrder = service.save(salesOrder);
        return salesOrder;
    }
}
