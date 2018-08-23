package com.trendsmixed.fma.module.subcontractarrivalreject;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractArrivalRejects")
public class SubcontractArrivalRejectController {

    private final SubcontractArrivalRejectService service;

    @JsonView(SubcontractArrivalRejectView.All.class)
    @GetMapping
    public Iterable<SubcontractArrivalReject> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractArrivalRejectView.AllAndLossReasonAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractorAndSubcontractOperationDefinitionAndItemAndProductTypeAndOperationType.class)
    @GetMapping("/page")
    Page<SubcontractArrivalReject> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractArrivalReject> subcontractArrivalRejectList) {

        try {

            service.save(subcontractArrivalRejectList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractArrivalRejectView.AllAndLossReasonAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractorAndSubcontractOperationDefinitionAndItemAndProductTypeAndOperationType.class)
    @GetMapping("/subcontractor/{id}")
    public Iterable<SubcontractArrivalReject> findBySubcontractor(@PathVariable("id") int id) {
        return service.findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractor(new Subcontractor(id));
    }

    @JsonView(SubcontractArrivalRejectView.AllAndLossReasonAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractorAndSubcontractOperationDefinitionAndItemAndProductTypeAndOperationType.class)
    @GetMapping(value = "/subcontractArrivalReject")
    public Page<SubcontractArrivalReject> getSubcontractArrivalReject(
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "job", required = false, defaultValue = "0") String job,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SubcontractArrivalReject> page ;
        if(subcontractor.equals("0")&&job.equals("0") ){
            page = new Page(service.findByArrivalRejectDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
         else if(job.equals("0")) {
            page = new Page(service.findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalRejectDateBetween(new Subcontractor(Integer.valueOf(subcontractor)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(subcontractor.equals("0")) {
            page = new Page(service.findBySubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else {
            page = new Page(service.findBySubcontractArrivalSubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractArrivalSubcontractOperationJobAndArrivalRejectDateBetween(new Subcontractor(Integer.valueOf(subcontractor)),new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public SubcontractArrivalReject save(@RequestBody SubcontractArrivalReject subcontractArrivalReject) {

        try {
            subcontractArrivalReject = service.save(subcontractArrivalReject);
            return subcontractArrivalReject;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractArrivalRejectView.AllAndLossReasonAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractorAndSubcontractOperationDefinitionAndItemAndProductTypeAndOperationType.class)
    @GetMapping("/{id}")
    public SubcontractArrivalReject findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractArrivalReject updateCustomer(@PathVariable int id, @RequestBody SubcontractArrivalReject subcontractArrivalReject) {

        subcontractArrivalReject.setId(id);
        subcontractArrivalReject = service.save(subcontractArrivalReject);
        return subcontractArrivalReject;
    }
}
