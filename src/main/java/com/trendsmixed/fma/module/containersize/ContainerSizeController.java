package com.trendsmixed.fma.module.containersize;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/containerSizes")
public class ContainerSizeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ContainerSizeService service;

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
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(ContainerSizeView.All.class)
    @PutMapping("/{id}")
    public ContainerSize updateCustomer(@PathVariable int id, @RequestBody ContainerSize containerSize,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        containerSize.setId(id);
        containerSize = service.save(containerSize);
        return containerSize;
    }
}
