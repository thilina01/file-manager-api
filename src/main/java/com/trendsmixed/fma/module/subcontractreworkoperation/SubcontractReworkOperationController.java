package com.trendsmixed.fma.module.subcontractreworkoperation;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractReworkOperations")
public class SubcontractReworkOperationController {

    private final SubcontractReworkOperationService service;

    @JsonView(SubcontractReworkOperationView.All.class)
    @GetMapping
    public Iterable<SubcontractReworkOperation> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractReworkOperationView.All.class)
    @GetMapping("/page")
    Page<SubcontractReworkOperation> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractReworkOperation> subcontractReworkOperationList) {

        try {

            service.save(subcontractReworkOperationList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    @JsonView(SubcontractReworkOperationView.All.class)
    @PostMapping
    public SubcontractReworkOperation save(@RequestBody SubcontractReworkOperation subcontractReworkOperation) {
        try {
            subcontractReworkOperation = service.save(subcontractReworkOperation);
            return subcontractReworkOperation;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractReworkOperationView.All.class)
    @GetMapping("/{id}")
    public SubcontractReworkOperation findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public SubcontractReworkOperation updateCustomer(@PathVariable int id, @RequestBody SubcontractReworkOperation subcontractReworkOperation) {
        subcontractReworkOperation.setId(id);
        subcontractReworkOperation = service.save(subcontractReworkOperation);
        return subcontractReworkOperation;
    }
}
