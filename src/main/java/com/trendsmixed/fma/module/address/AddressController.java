package com.trendsmixed.fma.module.address;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/addresses")
public class AddressController {

    
    private final AddressService service;

    @JsonView(AddressView.All.class)
    @GetMapping
    public Iterable<Address> findAll() {
        return service.findAll();
    }

    @JsonView(AddressView.AllAndAddressTypeAllAndCountryAllAndPortAll.class)
    @GetMapping("/page")
    Page<Address> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByCustomer/{id}")
    List<Combo> combo(@PathVariable("id") int id) {
        return service.getComboByCustomer(new Customer(id));
    }

    @JsonView(AddressView.AllAndAddressTypeAllAndCountryAllAndPortAll.class)
    @PostMapping
    public Address save(@RequestBody Address address) {
        
        try {
            address = service.save(address);
            return address;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(AddressView.AllAndAddressTypeAllAndCountryAllAndPortAll.class)
    @GetMapping("/{id}")
    public Address findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @JsonView(AddressView.AllAndAddressTypeAllAndCountryAllAndPortAll.class)
    @PutMapping("/{id}")
    public Address updateAddressType(@PathVariable int id, @RequestBody Address address) {
        
        address.setId(id);
        address = service.save(address);
        return address;
    }
}
