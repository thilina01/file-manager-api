package com.trendsmixed.fma.module.operationprogress;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/operationProgresses")
public class OperationProgressController {

    private final AppSessionService appSessionService;
    private final OperationProgressService service;

    @JsonView(OperationProgressView.All.class)
    @GetMapping
    public Iterable<OperationProgress> findAll() {
        return service.findAll();
    }

    @JsonView(OperationProgressView.All.class)
    @GetMapping("/page")
    Page<OperationProgress> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(OperationProgressView.All.class)
    @PostMapping
    public OperationProgress save(@RequestBody OperationProgress operationProgress,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            operationProgress = service.save(operationProgress);
            return operationProgress;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<OperationProgress> operationProgresses,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(operationProgresses);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(OperationProgressView.All.class)
    @GetMapping("/{id}")
    public OperationProgress findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(OperationProgressView.All.class)
    @PutMapping("/{id}")
    public OperationProgress updateCustomer(@PathVariable int id, @RequestBody OperationProgress operationProgress,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        operationProgress.setId(id);
        operationProgress = service.save(operationProgress);
        return operationProgress;
    }
}
