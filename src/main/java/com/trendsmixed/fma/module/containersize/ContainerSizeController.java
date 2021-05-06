package com.trendsmixed.fma.module.containersize;

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
@RequestMapping("/containerSizes")
public class ContainerSizeController {

    
    private final ContainerSizeService service;

    @JsonView(ContainerSizeView.All.class)
    @GetMapping
    public Iterable<ContainerSize> findAll() {
        return service.findAll();
    }

    @JsonView(ContainerSizeView.All.class)
    @GetMapping("/page")
    Page<ContainerSize> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ContainerSizeView.All.class)
    @PostMapping
    public ContainerSize save(@RequestBody ContainerSize containerSize,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            containerSize = service.save(containerSize);
            return containerSize;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ContainerSize> containerSizes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(containerSizes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ContainerSizeView.All.class)
    @GetMapping("/{id}")
    public ContainerSize findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);
    }

    @JsonView(ContainerSizeView.All.class)
    @PutMapping("/{id}")
    public ContainerSize updateCustomer(@PathVariable int id, @RequestBody ContainerSize containerSize,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        containerSize.setId(id);
        containerSize = service.save(containerSize);
        return containerSize;
    }
}
