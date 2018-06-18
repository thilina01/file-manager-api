package com.trendsmixed.fma.module.notifyparty;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/notifyParties")
public class NotifyPartyController {

    
    private final NotifyPartyService service;

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
    public NotifyParty save(@RequestBody NotifyParty notifyParty) {
        
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
    public void delete(@PathVariable int id) {
        
        service.delete(id);
    }

    @JsonView(NotifyPartyView.All.class)
    @PutMapping("/{id}")
    public NotifyParty updateCustomer(@PathVariable int id, @RequestBody NotifyParty notifyParty) {
        
        notifyParty.setId(id);
        notifyParty = service.save(notifyParty);
        return notifyParty;
    }
}
