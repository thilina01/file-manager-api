package com.trendsmixed.fma.module.delivery;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/deliveries")
public class DeliveryController {

    private final AppSessionService appSessionService;
    private final DeliveryService deliveryService;

    @JsonView(DeliveryView.All.class)
    @GetMapping
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }

    @JsonView(DeliveryView.All.class)
    @PostMapping
    public Delivery save(@RequestBody Delivery delivery, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        deliveryService.delete(id);

    }

    @PutMapping("/{id}")
    public Delivery updateCustomer(@PathVariable int id, @RequestBody Delivery delivery, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        delivery.setId(id);
        delivery = deliveryService.save(delivery);
        return delivery;
    }
}
