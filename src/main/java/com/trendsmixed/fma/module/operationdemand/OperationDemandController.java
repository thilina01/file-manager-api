package com.trendsmixed.fma.module.operationdemand;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/operationDemands")
public class OperationDemandController {

    private final OperationDemandService service;

    @LogExecution
    @JsonView(OperationDemandView.All.class)
    @GetMapping
    public Iterable<OperationDemand> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(OperationDemandView.All.class)
    @GetMapping("/page")
    public Page<OperationDemand> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @LogExecution
    @JsonView(OperationDemandView.All.class)
    @PostMapping
    public OperationDemand save(@RequestBody OperationDemand operationDemand,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            operationDemand = service.save(operationDemand);
            return operationDemand;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<OperationDemand> operationDemands,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(operationDemands);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(OperationDemandView.All.class)
    @GetMapping("/{id}")
    public OperationDemand findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);

    }

    @LogExecution
    @PutMapping("/{id}")
    public OperationDemand updateCustomer(@PathVariable int id, @RequestBody OperationDemand operationDemand,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        operationDemand.setId(id);
        operationDemand = service.save(operationDemand);
        return operationDemand;
    }


}
