package com.trendsmixed.fma.module.loadingplan;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/loadingPlans")
public class LoadingPlanController {

    
    private final LoadingPlanService service;

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping
    public Iterable<LoadingPlan> findAll() {
        return service.findAll();
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping("/page")
    Page<LoadingPlan> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping("/comboByCustomer/{id}")
    public Iterable<LoadingPlan> findByCustomer(@PathVariable("id") int id) {
        return service.findByCustomer(new Customer(id));
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @PostMapping
    public LoadingPlan save(@RequestBody LoadingPlan loadingPlan) {
        
        try {

            List<LoadingPlanItem> loadingPlanItems = loadingPlan.getLoadingPlanItemList();
            if (loadingPlanItems != null) {
                for (LoadingPlanItem loadingPlanItem : loadingPlanItems) {
                    loadingPlanItem.setLoadingPlan(loadingPlan);
                }
            }

            loadingPlan = service.save(loadingPlan);
            return loadingPlan;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchNoteAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer.class)
    @GetMapping("/{id}")
    public LoadingPlan findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LoadingPlan updateCustomer(@PathVariable int id, @RequestBody LoadingPlan loadingPlan) {
        
        loadingPlan.setId(id);
        loadingPlan = service.save(loadingPlan);
        return loadingPlan;
    }
}
