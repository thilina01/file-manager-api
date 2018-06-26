package com.trendsmixed.fma.module.subcontractoperationrate;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperation;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractOperationRates")
public class SubcontractOperationRateController {

    private final SubcontractOperationRateService service;

    @JsonView(SubcontractOperationRateView.All.class)
    @GetMapping
    public Iterable<SubcontractOperationRate> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/page")
    Page<SubcontractOperationRate> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractOperationRate> subcontractOperationRateList) {

        try {

            service.save(subcontractOperationRateList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping(value = "/subcontractOperationRate")
    public Page<SubcontractOperationRate> getSubcontractOperationRate(
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "subcontractOperationDefinition", required = false, defaultValue = "0") String subcontractOperationDefinition,
        Pageable pageable) throws ParseException {
        Page<SubcontractOperationRate> page ;
        if(subcontractOperationDefinition.equals("0") ){
            page = new Page(service.findBySubcontractorOperationSubcontractor(new Subcontractor(Integer.valueOf(subcontractor)), pageable));
        } 
        else if(subcontractor.equals("0") ){
            page = new Page(service.findBySubcontractorOperationSubcontractOperationDefinition(new SubcontractOperationDefinition(Integer.valueOf(subcontractOperationDefinition)), pageable));
        }
        else {
            page = new Page(service.findBySubcontractorOperationSubcontractorAndSubcontractorOperationSubcontractOperationDefinition(new Subcontractor(Integer.valueOf(subcontractor)),new SubcontractOperationDefinition(Integer.valueOf(subcontractOperationDefinition)), pageable));
        }
        return page;
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    
    @PostMapping
    public SubcontractOperationRate save(@RequestBody SubcontractOperationRate subcontractOperationRate) {
        try {
            subcontractOperationRate = service.save(subcontractOperationRate);
            return subcontractOperationRate;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }
    
    @JsonView(SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/subcontractor/{id}")
    public Iterable<SubcontractOperationRate> findBySubcontractor(@PathVariable("id") int id) {
        return service.findBySubcontractorOperationSubcontractor(new Subcontractor(id));
    }
    
    @JsonView(SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping(value = "/bySubcontractorAndItem")
    public  Iterable<SubcontractOperationRate> getBySubcontractorAndItem(
        @RequestParam(value = "subcontractor", required = true) int subcontractorId,
        @RequestParam(value = "item", required = true) int itemId){
        return service.findBySubcontractorOperationSubcontractorIdAndSubcontractorOperationSubcontractorOperationDefinitionItemId(subcontractorId, itemId);
    }

    @JsonView(SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/latestBysubcontractorOperationId")
    public SubcontractOperationRate getLatestBySubcontractorOperation(
    @RequestParam(value = "subcontractorOperationId") String subcontractorOperationId) {
        return service.findFirstBySubcontractorOperationOrderByDateOfRateDesc(new SubcontractorOperation(Integer.valueOf(subcontractorOperationId)));
    }

    @JsonView(SubcontractOperationRateView.AllAndSubcontractorOperationAndSubcontractOperationDefinitionAndItemAndOperationTypeAndProductTypeAndSubcontractor.class)
    @GetMapping("/{id}")
    public SubcontractOperationRate findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractOperationRate updateCustomer(@PathVariable int id, @RequestBody SubcontractOperationRate subcontractOperationRate) {
        subcontractOperationRate.setId(id);
        subcontractOperationRate = service.save(subcontractOperationRate);
        return subcontractOperationRate;
    }
}
