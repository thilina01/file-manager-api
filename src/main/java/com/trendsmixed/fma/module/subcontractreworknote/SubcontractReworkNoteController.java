package com.trendsmixed.fma.module.subcontractreworknote;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.module.subcontractreworkoperation.SubcontractReworkOperation;
import com.trendsmixed.fma.utility.Page;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractReworkNotes")
public class SubcontractReworkNoteController {

    private final SubcontractReworkNoteService service;

    @JsonView(SubcontractReworkNoteView.All.class)
    @GetMapping
    public Iterable<SubcontractReworkNote> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractReworkNoteView.AllAndAllAndSubcontractArrivalRejectAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndProductTypeAndItemAndSubcontractorAndLocation.class)
    @GetMapping("/page")
    Page<SubcontractReworkNote> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractReworkNote> subcontractReworkNoteList) {

        try {

            service.save(subcontractReworkNoteList);
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

    @JsonView(SubcontractReworkNoteView.AllAndAllAndSubcontractArrivalRejectAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndProductTypeAndItemAndSubcontractorAndLocation.class)
    @GetMapping(value = "/subcontractReworkNote")
    public Page<SubcontractReworkNote> getSubcontractReworkNote(
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SubcontractReworkNote> page ;
        if(subcontractor.equals("0") ){
            page = new Page(service.findByNoteTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else {
            page = new Page(service.findBySubcontractorAndNoteTimeBetween(new Subcontractor(Integer.valueOf(subcontractor)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @JsonView(SubcontractReworkNoteView.AllAndAllAndSubcontractArrivalRejectAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndProductTypeAndItemAndSubcontractorAndLocation.class)
    @GetMapping(value = "/subcontractReworkNoteRelease")
    public Page<SubcontractReworkNote> getSubcontractReworkNoteRelease(
        @RequestParam(value = "location", required = false, defaultValue = "0") String location,
        @RequestParam(value = "subcontractor", required = false, defaultValue = "0") String subcontractor,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<SubcontractReworkNote> page ;
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


    @PostMapping("/releaseInformation")
    public SubcontractReworkNote saveReleaseInformation(@RequestBody SubcontractReworkNote subcontractReworkNote) {
        try {
            SubcontractReworkNote existingSubcontractReworkNote = service.findById(subcontractReworkNote.getId());
            existingSubcontractReworkNote.setRecipient(subcontractReworkNote.getRecipient());
            existingSubcontractReworkNote.setContainerNumber(subcontractReworkNote.getContainerNumber());
            existingSubcontractReworkNote.setVehicleNumber(subcontractReworkNote.getVehicleNumber());
            existingSubcontractReworkNote.setSubcontractReleaseTime(subcontractReworkNote.getSubcontractReleaseTime());
            existingSubcontractReworkNote.setLocation(subcontractReworkNote.getLocation());
            return service.save(existingSubcontractReworkNote);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping
    public SubcontractReworkNote save(@RequestBody SubcontractReworkNote subcontractReworkNote) {
        try {
            List<SubcontractReworkOperation> subcontractReworkOperations = subcontractReworkNote.getSubcontractReworkOperationList();
            if (subcontractReworkOperations != null) {
                for (SubcontractReworkOperation subcontractReworkOperation : subcontractReworkOperations) {
                    subcontractReworkOperation.setSubcontractReworkNote(subcontractReworkNote);
                }
            }

      subcontractReworkNote = service.save(subcontractReworkNote);
            return subcontractReworkNote;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractReworkNoteView.AllAndAllAndSubcontractArrivalRejectAndSubcontractArrivalAndSubcontractOperationAndJobAndSubcontractOperationRateAndSubcontractorOperationAndSubcontractOperationDefinitionAndProductTypeAndItemAndSubcontractorAndLocation.class)
    @GetMapping("/{id}")
    public SubcontractReworkNote findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public SubcontractReworkNote updateCustomer(@PathVariable int id, @RequestBody SubcontractReworkNote subcontractReworkNote) {
        subcontractReworkNote.setId(id);
        subcontractReworkNote = service.save(subcontractReworkNote);
        return subcontractReworkNote;
    }
}
