package com.trendsmixed.fma.module.subcontractarrival;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractArrivals")
public class SubcontractArrivalController {

    private final SubcontractArrivalService service;

    @JsonView(SubcontractArrivalView.All.class)
    @GetMapping
    public Iterable<SubcontractArrival> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractArrivalView.AllAndSubcontractOperationAndSubcontractNoteAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndItemAndProductTypeAndOperationType.class)
    @GetMapping("/page")
    Page<SubcontractArrival> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractArrival> subcontractArrivalList) {

        try {

            service.save(subcontractArrivalList);
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

    @PostMapping
    public SubcontractArrival save(@RequestBody SubcontractArrival subcontractArrival) {

        try {
            subcontractArrival = service.save(subcontractArrival);
            return subcontractArrival;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractArrivalView.AllAndSubcontractOperationAndSubcontractNoteAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndItemAndProductTypeAndOperationType.class)
    @GetMapping("/subcontractNote/{id}")
    public Iterable<SubcontractArrival> findBySubcontractNote(@PathVariable("id") int id) {
        return service.findBySubcontractOperationSubcontractNote(new SubcontractNote(id));
    }

    @JsonView(SubcontractArrivalView.AllAndSubcontractOperationAndSubcontractNoteAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndItemAndProductTypeAndOperationType.class)
    @GetMapping(value = "/subcontractArrival")
    public Page<SubcontractArrival> getSubcontractArrival(
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "job", required = false, defaultValue = "0") String job,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SubcontractArrival> page ;
        if(subcontractor.equals("0")&&job.equals("0") ){
            page = new Page(service.findByArrivalTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(job.equals("0")) {
            page = new Page(service.findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndArrivalTimeBetween(new Subcontractor(Integer.valueOf(subcontractor)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(subcontractor.equals("0")) {
            page = new Page(service.findBySubcontractOperationJobAndArrivalTimeBetween(new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else {
            page = new Page(service.findBySubcontractOperationSubcontractOperationRateSubcontractorOperationSubcontractorAndSubcontractOperationJobAndArrivalTimeBetween(new Subcontractor(Integer.valueOf(subcontractor)),new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @JsonView(SubcontractArrivalView.AllAndSubcontractOperationAndSubcontractNote.class)
    @GetMapping("/{id}")
    public SubcontractArrival findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractArrival updateCustomer(@PathVariable int id, @RequestBody SubcontractArrival subcontractArrival) {

        subcontractArrival.setId(id);
        subcontractArrival = service.save(subcontractArrival);
        return subcontractArrival;
    }
}
