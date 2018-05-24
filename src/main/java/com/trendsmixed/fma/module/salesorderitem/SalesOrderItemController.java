package com.trendsmixed.fma.module.salesorderitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.customeritem.CustomerItem;
import com.trendsmixed.fma.module.customeritem.CustomerItemService;
import com.trendsmixed.fma.module.salesorder.SalesOrder;

import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import com.trendsmixed.fma.utility.Page;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesOrderItems")
public class SalesOrderItemController {

    private final AppSessionService appSessionService;
    private final SalesOrderItemService service;

    @GetMapping
    @JsonView(SalesOrderItemView.AllAndCustomerItemAllAndSalesOrderAllAndDispatchScheduleAll.class)
    public Iterable<SalesOrderItem> findAll() {
        return service.findAll();
    }

    @JsonView(SalesOrderItemView.AllAndDispatchScheduleAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoiceAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint.class)
    @GetMapping("/page")
    Page<SalesOrderItem> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }
    
    @GetMapping(value = "/salesOrderItemDurationPage", params = {"startDate", "endDate"})
    public Page<SalesOrderItem> SalesOrderItemDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderOrderDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @GetMapping(value = "/customerAndSalesOrderItemDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<SalesOrderItem> customerAndSalesOrderItemDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderCustomerAndSalesOrderOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @GetMapping(value = "/salesOrderAndSalesOrderItemDurationPage", params = {"salesOrder", "startDate", "endDate"})
    public Page<SalesOrderItem> SalesOrderAndSalesOrderItemDurationPage(@RequestParam("salesOrder") String salesOrder, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderAndSalesOrderOrderDateBetween(new SalesOrder(Integer.valueOf(salesOrder)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @GetMapping(value = "/customerItemAndSalesOrderItemDurationPage", params = {"customerItem", "startDate", "endDate"})
    public Page<SalesOrderItem> customerItemAndOrderDateDurationPage(@RequestParam("customerItem") String customerItem, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerItemAndSalesOrderOrderDateBetween(new CustomerItem(Integer.valueOf(customerItem)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @GetMapping(value = "/customerItemAndSalesOrderItemDurationAndSalesOrderPage", params = {"customerItem", "startDate", "endDate", "salesOrder"})
    public Page<SalesOrderItem> customerItemAndSalesOrderItemDurationAndSalesOrderPage(@RequestParam("customerItem") String customerItem, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("salesOrder") String salesOrder, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrder(new CustomerItem(Integer.valueOf(customerItem)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrder(Integer.valueOf(salesOrder)), pageable));
    }

    @GetMapping(value = "/customerItemAndSalesOrderItemDurationAndCustomerPage", params = {"customerItem", "startDate", "endDate", "customer"})
    public Page<SalesOrderItem> customerItemAndSalesOrderItemDurationAndCustomerPage(@RequestParam("customerItem") String customerItem, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("customer") String customer, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(new CustomerItem(Integer.valueOf(customerItem)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Customer(Integer.valueOf(customer)), pageable));
    }

    @GetMapping(value = "/salesOrderAndSalesOrderItemDurationAndCustomerPage", params = {"salesOrder", "startDate", "endDate", "customer"})
    public Page<SalesOrderItem> salesOrderAndSalesOrderItemDurationAndCustomerPage(@RequestParam("salesOrder") String salesOrder, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("customer") String customer, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(new SalesOrder(Integer.valueOf(salesOrder)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Customer(Integer.valueOf(customer)), pageable));
    }

    @GetMapping(value = "/salesOrderAndCustomerItemAndSalesOrderItemDurationAndCustomerPage", params = {"customer","customerItem", "salesOrder","startDate", "endDate" })
    public Page<SalesOrderItem> salesOrderAndCustomerItemAndSalesOrderItemDurationAndCustomerPage(@RequestParam("customer") String customer,@RequestParam("customerItem") String customerItem,@RequestParam("salesOrder") String salesOrder, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,  Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderCustomerAndCustomerItemAndSalesOrderAndAndSalesOrderOrderDateBetween(new Customer(Integer.valueOf(customer)),new CustomerItem(Integer.valueOf(customerItem)),new SalesOrder(Integer.valueOf(salesOrder)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),  pageable));
    }

    @JsonView(SalesOrderItemView.AllAndDispatchScheduleAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoiceAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint.class)
    @GetMapping(value = "/salesOrderBook")
    public Page<SalesOrderItem> getSalesOrderBook(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "customerItem", required = false, defaultValue = "0") String customerItem,   
        @RequestParam(value = "salesOrder", required = false, defaultValue = "0") String salesOrder,   
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SalesOrderItem> page ;

        if(customer.equals("0")&& customerItem.equals("0")&& salesOrder.equals("0") ){
            page = new Page(service.findBySalesOrderOrderDateBetween( Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 

        else if(customer.equals("0")&& salesOrder.equals("0") ){
            page = new Page(service.findByCustomerItemAndSalesOrderOrderDateBetween(new CustomerItem(Integer.valueOf(customerItem)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }

        else if(customerItem.equals("0")&& salesOrder.equals("0") ){
            page = new Page(service.findBySalesOrderCustomerAndSalesOrderOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }

        else if(customerItem.equals("0")&& customer.equals("0") ){
            page = new Page(service.findBySalesOrderAndSalesOrderOrderDateBetween(new SalesOrder(Integer.valueOf(salesOrder)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }

        else if(salesOrder.equals("0") ){
            page = new Page(service.findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(new CustomerItem(Integer.valueOf(customerItem)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Customer(Integer.valueOf(customer)), pageable));
        }

        else if(customer.equals("0")  ){
            page = new Page(service.findByCustomerItemAndSalesOrderOrderDateBetweenAndSalesOrder(new CustomerItem(Integer.valueOf(customerItem)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrder(Integer.valueOf(salesOrder)), pageable));
        }

        else if(customerItem.equals("0")  ){
            page = new Page(service.findBySalesOrderAndSalesOrderOrderDateBetweenAndSalesOrderCustomer(new SalesOrder(Integer.valueOf(salesOrder)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Customer(Integer.valueOf(customer)), pageable));
        }

        else {
            page = new Page(service.findBySalesOrderCustomerAndCustomerItemAndSalesOrderAndAndSalesOrderOrderDateBetween(new Customer(Integer.valueOf(customer)),new CustomerItem(Integer.valueOf(customerItem)),new SalesOrder(Integer.valueOf(salesOrder)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),  pageable));
        }
        
        return page;
    }

    @PostMapping
    public SalesOrderItem save(@RequestBody SalesOrderItem salesOrderItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            salesOrderItem = service.save(salesOrderItem);
            return salesOrderItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndDispatchScheduleAll.class)
    @GetMapping("/{id}")
    public SalesOrderItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrderItem updateCustomer(@PathVariable int id, @RequestBody SalesOrderItem salesOrderItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderItem.setId(id);
        salesOrderItem = service.save(salesOrderItem);
        return salesOrderItem;
    }
}
