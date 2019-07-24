package com.trendsmixed.fma.module.internaltransferitem;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/internalTransferItems")
public class InternalTransferItemController {

    private final InternalTransferItemService service;

    @JsonView(InternalTransferItemView.All.class)
    @GetMapping
    public Iterable<InternalTransferItem> findAll() {
        return service.findAll();
    }

    @JsonView(InternalTransferItemView.AllAndProductTypeAndJobAndItemAndInternalTransferNoteAndFromLocationAndToLocation.class)
    @GetMapping("/page")
    Page<InternalTransferItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @JsonView(InternalTransferItemView.AllAndProductTypeAndJobAndItemAndInternalTransferNoteAndFromLocationAndToLocation.class)
    @GetMapping(value = "/internalTransferInformation")
    public Page<InternalTransferItem> getInternalTransferInformation(
        @RequestParam(value = "fromLocation", required = false, defaultValue = "0") String fromLocation,
        @RequestParam(value = "toLocation", required = false, defaultValue = "0") String toLocation,
        @RequestParam(value = "job", required = false, defaultValue = "0") String job,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<InternalTransferItem> page ;
        if(fromLocation.equals("0")&&toLocation.equals("0")&&job.equals("0") ){
            page = new Page(service.findByInternalTransferNoteNoteDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(toLocation.equals("0")&&job.equals("0")){
            page = new Page(service.findByInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(new Location(Integer.valueOf(fromLocation)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else  if(fromLocation.equals("0")&&job.equals("0")){
            page = new Page(service.findByInternalTransferNoteToLocationAndInternalTransferNoteNoteDateBetween(new Location(Integer.valueOf(toLocation)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else  if(fromLocation.equals("0")&&toLocation.equals("0")){
            page = new Page(service.findByJobAndInternalTransferNoteNoteDateBetween(new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else  if(job.equals("0")){
            page = new Page(service.findByInternalTransferNoteToLocationAndInternalTransferNoteFromLocationAndInternalTransferNoteNoteDateBetween(new Location(Integer.valueOf(toLocation)),new Location(Integer.valueOf(fromLocation)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else  if(toLocation.equals("0")){
            page = new Page(service.findByInternalTransferNoteFromLocationAndJobAndInternalTransferNoteNoteDateBetween(new Location(Integer.valueOf(fromLocation)),new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else  if(fromLocation.equals("0")){
            page = new Page(service.findByInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(new Location(Integer.valueOf(toLocation)),new Job(Integer.valueOf(job)) ,Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else {
            page = new Page(service.findByInternalTransferNoteFromLocationAndInternalTransferNoteToLocationAndJobAndInternalTransferNoteNoteDateBetween(new Location(Integer.valueOf(fromLocation)),new Location(Integer.valueOf(toLocation)),new Job(Integer.valueOf(job)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        return page;
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<InternalTransferItem> internalTransferItemList) {

        try {

            service.save(internalTransferItemList);
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
    @JsonView(InternalTransferItemView.All.class)
    @PostMapping
    public InternalTransferItem save(@RequestBody InternalTransferItem internalTransferItem) {
        try {
            internalTransferItem = service.save(internalTransferItem);
            return internalTransferItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InternalTransferItemView.All.class)
    @GetMapping("/{id}")
    public InternalTransferItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public InternalTransferItem updateCustomer(@PathVariable int id, @RequestBody InternalTransferItem internalTransferItem) {
        internalTransferItem.setId(id);
        internalTransferItem = service.save(internalTransferItem);
        return internalTransferItem;
    }
}
