package com.trendsmixed.fma.module.dispatchnote;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.trendsmixed.fma.utility.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/dispatchNotes")
public class DispatchNoteController {

    private final AppSessionService appSessionService;
    private final DispatchNoteService service;

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAll.class)
    @GetMapping
    public Iterable<DispatchNote> findAll() {
        return service.findAll();
    }

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAll.class)
    @GetMapping("/page")
    Page<DispatchNote> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));

    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByCustomer/{id}")
    List<Combo> combo(@PathVariable("id") int id) {
        return service.getComboByCustomer(new Customer(id));
    }

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAllAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping("/id/{id}")
    public DispatchNote findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAll.class)
    @PostMapping
    public DispatchNote save(@RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            List<Dispatch> dispatches = dispatchNote.getDispatchList();
            if (dispatches != null) {
                for (Dispatch dispatch : dispatches) {
                    dispatch.setDispatchNote(dispatchNote);
                }
            }
            dispatchNote = service.save(dispatchNote);
            return dispatchNote;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAll.class)
    @PostMapping("/release")
    public DispatchNote saveReleaseInformation(@RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            DispatchNote existingDispatchNote = service.findOne(dispatchNote.getId());
            existingDispatchNote.setRecipient(dispatchNote.getRecipient());
            existingDispatchNote.setContainerNumber(dispatchNote.getContainerNumber());
            existingDispatchNote.setVehicleNumber(dispatchNote.getVehicleNumber());
            existingDispatchNote.setDispatchReleaseTime(dispatchNote.getDispatchReleaseTime());
            return service.save(existingDispatchNote);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<DispatchNote> dispatchNotes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(dispatchNotes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchNoteView.AllAndCustomerAndAddressAndEmployeeAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @GetMapping("/{id}")
    public DispatchNote findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAll.class)
    @PutMapping("/{id}")
    public DispatchNote updateCustomer(@PathVariable int id, @RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatchNote.setId(id);
        dispatchNote = service.save(dispatchNote);
        return dispatchNote;
    }

}
