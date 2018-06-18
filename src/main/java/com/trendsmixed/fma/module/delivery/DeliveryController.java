package com.trendsmixed.fma.module.delivery;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/deliveries")
public class DeliveryController {

    
    private final DeliveryService deliveryService;

    @JsonView(DeliveryView.All.class)
    @GetMapping
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }

    @JsonView(DeliveryView.All.class)
    @PostMapping
    public Delivery save(@RequestBody Delivery delivery) {
        
        try {
            delivery = deliveryService.save(delivery);
            return delivery;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Delivery findOne(@PathVariable("id") int id) {
        return deliveryService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        deliveryService.delete(id);

    }

    @PutMapping("/{id}")
    public Delivery updateCustomer(@PathVariable int id, @RequestBody Delivery delivery) {
        
        delivery.setId(id);
        delivery = deliveryService.save(delivery);
        return delivery;
    }
}
