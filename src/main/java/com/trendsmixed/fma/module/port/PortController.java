package com.trendsmixed.fma.module.port;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/ports")
public class PortController {

    
    private final PortService service;
    
    @JsonView(PortView.All.class)
    @GetMapping
    public Iterable<Port> findAll() {
        return service.findAll();
    }

    @JsonView(PortView.All.class)
    @GetMapping("/page")
    Page<Port> page(Pageable pageable) {
        return new Page<Port>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
   
    @JsonView(PortView.All.class)
    @GetMapping("/findByCustomer/{id}")
     List <Port> findByCustomer(@PathVariable("id") int customerId) {
        return service.findByAddressListCustomerId(customerId);
    }

    @JsonView(PortView.All.class)
    @PostMapping
    public Port save(@RequestBody Port port, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        try {
            port = service.save(port);
            return port;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Port> ports,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(ports);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PortView.All.class)
    @GetMapping("/{id}")
    public Port findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @JsonView(PortView.All.class)
    @PutMapping("/{id}")
    public Port updateCustomer(@PathVariable int id, @RequestBody Port port,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        port.setId(id);
        port = service.save(port);
        return port;
    }
}
