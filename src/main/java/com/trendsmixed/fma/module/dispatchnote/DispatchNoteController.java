package com.trendsmixed.fma.module.dispatchnote;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.trendsmixed.fma.utility.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import org.springframework.data.domain.Pageable;

@RestController
@CrossOrigin
@RequestMapping("/dispatchNotes")
public class DispatchNoteController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DispatchNoteService service;

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

    @JsonView(DispatchNoteView.AllAndAddressAllAndEmployeeAllAndCustomerAllAndDispatchAllAndDispatchScheduleAll.class)
    @GetMapping("/{id}")
    public DispatchNote findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public DispatchNote updateCustomer(@PathVariable int id, @RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatchNote.setId(id);
        dispatchNote = service.save(dispatchNote);
        return dispatchNote;
    }
}
