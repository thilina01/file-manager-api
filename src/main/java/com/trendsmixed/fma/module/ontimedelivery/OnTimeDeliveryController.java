package com.trendsmixed.fma.module.ontimedelivery;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/onTimeDeliveries")
public class OnTimeDeliveryController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private OnTimeDeliveryService service;

    @JsonView(OnTimeDeliveryView.AllAndCustomerAll.class)
    @GetMapping
    public Iterable<OnTimeDelivery> findAll() {
        return service.findAll();
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(OnTimeDeliveryView.AllAndCustomerAll.class)
    @GetMapping("/page")
    Page<OnTimeDelivery> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @JsonView(OnTimeDeliveryView.AllAndCustomerAll.class)
    @PostMapping
    public OnTimeDelivery save(@RequestBody OnTimeDelivery onTimeDelivery) {

        
        try {
            onTimeDelivery = service.save(onTimeDelivery);
            return onTimeDelivery;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<OnTimeDelivery> onTimeDeliveries) {

        
        try {
            service.save(onTimeDeliveries);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(OnTimeDeliveryView.AllAndCustomerAll.class)
    public OnTimeDelivery findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public OnTimeDelivery updateCustomer(@PathVariable int id, @RequestBody OnTimeDelivery onTimeDelivery) {
        
        onTimeDelivery.setId(id);
        onTimeDelivery = service.save(onTimeDelivery);
        return onTimeDelivery;
    }

}
