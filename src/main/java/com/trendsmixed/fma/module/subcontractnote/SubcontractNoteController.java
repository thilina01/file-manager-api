package com.trendsmixed.fma.module.subcontractnote;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.utility.Page;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractNotes")
public class SubcontractNoteController {

    private final SubcontractNoteService service;

    @JsonView(SubcontractNoteView.All.class)
    @GetMapping
    public Iterable<SubcontractNote> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractNoteView.AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndLocation.class)
    @GetMapping("/page")
    Page<SubcontractNote> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @JsonView(SubcontractNoteView.AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractor.class)
    @GetMapping(value = "/subcontractNote")
    public Page<SubcontractNote> getSubcontractNote(
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SubcontractNote> page ;
        if(subcontractor.equals("0") ){
            page = new Page(service.findByNoteTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else {
            page = new Page(service.findBySubcontractorAndNoteTimeBetween(new Subcontractor(Integer.valueOf(subcontractor)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @JsonView(SubcontractNoteView.AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndLocation.class)
    @GetMapping(value = "/subcontractRelease")
    public Page<SubcontractNote> getSubcontractRelease(
        @RequestParam(value = "location", required = false, defaultValue = "0") String location,
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SubcontractNote> page ;
        if(location.equals("0") && subcontractor.equals("0") ){
            page = new Page(service.findBySubcontractReleaseTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(location.equals("0")){
            page = new Page(service.findBySubcontractorAndSubcontractReleaseTimeBetween(new Subcontractor(Integer.valueOf(subcontractor)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(subcontractor.equals("0")){
            page = new Page(service.findByLocationAndSubcontractReleaseTimeBetween(new Location(Integer.valueOf(location)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else {
            page = new Page(service.findByLocationAndSubcontractorAndSubcontractReleaseTimeBetween(new Location(Integer.valueOf(location)),new Subcontractor(Integer.valueOf(subcontractor)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractNote> subcontractNoteList) {

        try {

            service.save(subcontractNoteList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/release")
    public SubcontractNote saveReleaseInformation(@RequestBody SubcontractNote subcontractNote) {
        try {
            SubcontractNote existingSubcontractNote = service.findOne(subcontractNote.getId());
            existingSubcontractNote.setRecipient(subcontractNote.getRecipient());
            existingSubcontractNote.setContainerNumber(subcontractNote.getContainerNumber());
            existingSubcontractNote.setVehicleNumber(subcontractNote.getVehicleNumber());
            existingSubcontractNote.setSubcontractReleaseTime(subcontractNote.getSubcontractReleaseTime());
            existingSubcontractNote.setLocation(subcontractNote.getLocation());
            return service.save(existingSubcontractNote);

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
    public SubcontractNote save(@RequestBody SubcontractNote subcontractNote) {
        try {

    List<SubcontractOperation> subcontractOperations = subcontractNote.getSubcontractOperationList();
    if (subcontractOperations != null) {
        for (SubcontractOperation subcontractOperation : subcontractOperations) {
            subcontractOperation.setSubcontractNote(subcontractNote);
        }
    }

      subcontractNote = service.save(subcontractNote);
            return subcontractNote;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractNoteView.AllAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndSubcontractorAndItemAndOperationTypeAndProductType.class)
    @GetMapping("/{id}")
    public SubcontractNote findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractNote updateCustomer(@PathVariable int id, @RequestBody SubcontractNote subcontractNote) {
        subcontractNote.setId(id);
        subcontractNote = service.save(subcontractNote);
        return subcontractNote;
    }
}
