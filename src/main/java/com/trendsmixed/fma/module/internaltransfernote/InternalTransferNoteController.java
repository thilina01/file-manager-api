package com.trendsmixed.fma.module.internaltransfernote;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.internaltransferitem.InternalTransferItem;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.utility.Page;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/internalTransferNotes")
public class InternalTransferNoteController {

    private final InternalTransferNoteService service;

    @JsonView(InternalTransferNoteView.All.class)
    @GetMapping
    public Iterable<InternalTransferNote> findAll() {
        return service.findAll();
    }

    @JsonView(InternalTransferNoteView.AllAndFromLocationAndToLocationAndInternalTransferItemAndProductTypeAndJobAndItem.class)
    @GetMapping("/page")
    Page<InternalTransferNote> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @JsonView(InternalTransferNoteView.AllAndFromLocationAndToLocationAndInternalTransferItemAndProductTypeAndJobAndItem.class)
    @GetMapping(value = "/note")
    public Page<InternalTransferNote> getInternalTransferNote(
        @RequestParam(value = "fromLocation", required = false, defaultValue = "0") String fromLocation,
        @RequestParam(value = "toLocation", required = false, defaultValue = "0") String toLocation,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<InternalTransferNote> page ;
        if(fromLocation.equals("0")&&toLocation.equals("0") ){
            page = new Page(service.findByNoteDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(toLocation.equals("0")){
            page = new Page(service.findByFromLocationAndNoteDateBetween(new Location(Integer.valueOf(fromLocation)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else  if(fromLocation.equals("0")){
            page = new Page(service.findByToLocationAndNoteDateBetween(new Location(Integer.valueOf(toLocation)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else {
            page = new Page(service.findByFromLocationAndToLocationAndNoteDateBetween(new Location(Integer.valueOf(fromLocation)),new Location(Integer.valueOf(toLocation)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        return page;
    }

    @JsonView(InternalTransferNoteView.AllAndFromLocationAndToLocationAndInternalTransferItemAndProductTypeAndJobAndItem.class)
    @GetMapping(value = "/release")
    public Page<InternalTransferNote> getInternalTransferNoteRelease(
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<InternalTransferNote> page ;
        page = new Page(service.findByNoteDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        return page;
    }

    @JsonView(InternalTransferNoteView.AllAndFromLocationAndToLocationAndInternalTransferItemAndProductTypeAndJobAndItem.class)
    @GetMapping(value = "/arrival")
    public Page<InternalTransferNote> getInternalTransferArrival(
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<InternalTransferNote> page ;
        page = new Page(service.findByReleaseTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        return page;
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<InternalTransferNote> internalTransferNoteList) {

        try {

            service.save(internalTransferNoteList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/release")
    public InternalTransferNote saveReleaseInformation(@RequestBody InternalTransferNote internalTransferNote) {
        try {
            InternalTransferNote existingInternalTransferNote = service.findById(internalTransferNote.getId());
            existingInternalTransferNote.setRecipient(internalTransferNote.getRecipient());
            existingInternalTransferNote.setVehicleNumber(internalTransferNote.getVehicleNumber());
            existingInternalTransferNote.setReleaseTime(internalTransferNote.getReleaseTime());
            return service.save(existingInternalTransferNote);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/arrival")
    public InternalTransferNote saveInternalTransferArrival(@RequestBody InternalTransferNote internalTransferNote) {
        try {
            InternalTransferNote existingInternalTransferNote = service.findById(internalTransferNote.getId());
            existingInternalTransferNote.setArrivalTime(internalTransferNote.getArrivalTime());
            return service.save(existingInternalTransferNote);

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
    public InternalTransferNote save(@RequestBody InternalTransferNote internalTransferNote) {
        try {

    List<InternalTransferItem> internalTransferItems = internalTransferNote.getInternalTransferItemList();
    if (internalTransferItems != null) {
        for (InternalTransferItem internalTransferItem : internalTransferItems) {
            internalTransferItem.setInternalTransferNote(internalTransferNote);
        }
    }

      internalTransferNote = service.save(internalTransferNote);
            return internalTransferNote;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InternalTransferNoteView.AllAndFromLocationAndToLocationAndInternalTransferItemAndProductTypeAndJobAndItem.class)
    @GetMapping("/{id}")
    public InternalTransferNote findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public InternalTransferNote updateCustomer(@PathVariable int id, @RequestBody InternalTransferNote internalTransferNote) {
        internalTransferNote.setId(id);
        internalTransferNote = service.save(internalTransferNote);
        return internalTransferNote;
    }
}
