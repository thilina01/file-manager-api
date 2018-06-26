package com.trendsmixed.fma.module.subcontractoroperation;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.utility.Page;
import java.text.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractorOperations")
public class SubcontractorOperationController {

    private final SubcontractorOperationService service;

    @JsonView(SubcontractorOperationView.All.class)
    @GetMapping
    public Iterable<SubcontractorOperation> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/page")
    Page<SubcontractorOperation> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping(value = "/subcontractorOperation")
    public Page<SubcontractorOperation> getSubcontractorOperation(
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        Pageable pageable) throws ParseException {
        Page<SubcontractorOperation> page ;
        
        page = new Page(service.findBySubcontractor(new Subcontractor(Integer.valueOf(subcontractor)), pageable));
        
        return page;
    }

    @JsonView(SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/subcontractor/{id}")
    public Iterable<SubcontractorOperation> findBySubcontractor(@PathVariable("id") int id) {
        return service.findBySubcontractor(new Subcontractor(id));
    }

    // @GetMapping("/getRate")
    // public List getByRate (
    // @RequestParam(value = "subcontractOperationDefinitionId") String subcontractOperationDefinitionId,
    // @RequestParam(value = "date") long date){
    //     return service.findOneBySubcontractOperationDefinition(new SubcontractOperationDefinition(Integer.valueOf(subcontractOperationDefinitionId)), new Date(date));
    // }

    @JsonView(SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractorOperation> subcontractorOperationList) {

        try {

            service.save(subcontractorOperationList);
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

    @JsonView(SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @PostMapping
    public void save(@RequestBody SubcontractorOperation subcontractorOperation) {
        try {

      //subcontractorOperation = 
      service.save(subcontractorOperation);
            //return subcontractorOperation;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractorOperationView.AllAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/{id}")
    public SubcontractorOperation findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractorOperation updateCustomer(@PathVariable int id, @RequestBody SubcontractorOperation subcontractorOperation) {
        subcontractorOperation.setId(id);
        subcontractorOperation = service.save(subcontractorOperation);
        return subcontractorOperation;
    }
}
