package com.trendsmixed.fma.module.subcontractoperation;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractOperations")
public class SubcontractOperationController {

    private final SubcontractOperationService service;

    @JsonView(SubcontractOperationView.All.class)
    @GetMapping
    public Iterable<SubcontractOperation> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractOperationView.AllAndSubcontractNoteAndJobAndSubcontractOperationRate.class)
    @GetMapping("/page")
    Page<SubcontractOperation> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractOperation> subcontractOperationList) {

        try {

            service.save(subcontractOperationList);
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
    @JsonView(SubcontractOperationView.All.class)
    @PostMapping
    public SubcontractOperation save(@RequestBody SubcontractOperation subcontractOperation) {
        try {
            subcontractOperation = service.save(subcontractOperation);
            return subcontractOperation;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractOperationView.AllAndSubcontractNote.class)
    @GetMapping("/subcontractNote/{id}")
    public Iterable<SubcontractOperation> findBySubcontractNote(@PathVariable("id") int id) {
        return service.findBySubcontractNote(new SubcontractNote(id));
    }

    @JsonView(SubcontractOperationView.AllAndSubcontractNoteAndJobAndSubcontractOperationRate.class)
    @GetMapping("/{id}")
    public SubcontractOperation findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractOperation updateCustomer(@PathVariable int id, @RequestBody SubcontractOperation subcontractOperation) {
        subcontractOperation.setId(id);
        subcontractOperation = service.save(subcontractOperation);
        return subcontractOperation;
    }
}
