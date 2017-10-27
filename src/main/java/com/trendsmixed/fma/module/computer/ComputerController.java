package com.trendsmixed.fma.module.computer;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/computers")
public class ComputerController {

    private final AppSessionService appSessionService;
    private final ComputerService service;

    @JsonView(ComputerView.All.class)
    @GetMapping
    public Iterable<Computer> findAll() {
        return service.findAll();
    }

    @JsonView(ComputerView.AllAndEmployeeAllAndComputerTypeAll.class)
    @GetMapping("/page")
    Page<Computer> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(ComputerView.All.class)
    @PostMapping
    public Computer save(@RequestBody Computer computer, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            computer = service.save(computer);
            return computer;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Computer> computers,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(computers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ComputerView.AllAndEmployeeAllAndComputerTypeAll.class)
    @GetMapping("/{id}")
    public Computer findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(ComputerView.All.class)
    @PutMapping("/{id}")
    public Computer updateCustomer(@PathVariable int id, @RequestBody Computer computer,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        computer.setId(id);
        computer = service.save(computer);
        return computer;
    }
}
