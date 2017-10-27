package com.trendsmixed.fma.module.operationtype;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/operationTypes")
public class OperationTypeController {

    private final AppSessionService appSessionService;
    private final OperationTypeService service;

    @JsonView(OperationTypeView.All.class)
    @GetMapping
    public Iterable<OperationType> findAll() {
        return service.findAll();
    }

    @JsonView(OperationTypeView.All.class)
    @GetMapping("/page")
    Page<OperationType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public OperationType save(@RequestBody OperationType operationType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            operationType = service.save(operationType);
            return operationType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(OperationTypeView.All.class)
    @GetMapping("/{id}")
    public OperationType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public OperationType updateCustomer(@PathVariable int id, @RequestBody OperationType operationType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operationType.setId(id);
        operationType = service.save(operationType);
        return operationType;
    }
}
