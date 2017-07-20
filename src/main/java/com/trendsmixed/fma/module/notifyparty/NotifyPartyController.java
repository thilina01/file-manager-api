package com.trendsmixed.fma.module.notifyparty;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.NotifyParty;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/notifyParties")
public class NotifyPartyController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private NotifyPartyService service;

    @JsonView(NotifyPartyView.All.class)
    @GetMapping
    public Iterable<NotifyParty> findAll() {
        return service.findAll();
    }

    @JsonView(NotifyPartyView.All.class)
    @GetMapping("/page")
    Page<NotifyParty> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(NotifyPartyView.All.class)
    @PostMapping
    public NotifyParty save(@RequestBody NotifyParty notifyParty, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            notifyParty = service.save(notifyParty);
            return notifyParty;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(NotifyPartyView.All.class)
    @GetMapping("/{id}")
    public NotifyParty findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public NotifyParty updateCustomer(@PathVariable int id, @RequestBody NotifyParty notifyParty, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        notifyParty.setId(id);
        notifyParty = service.save(notifyParty);
        return notifyParty;
    }

}
