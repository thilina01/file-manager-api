package com.trendsmixed.fma.module.losstype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/lossTypes")
public class LossTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private LossTypeService service;

    @JsonView(LossTypeView.AllAndLossReasonList.class)
    @GetMapping
    public Iterable<LossType> findAll() {
        return service.findAll();
    }

    @JsonView(LossTypeView.All.class)
    @GetMapping("/page")
    Page<LossType> page(Pageable pageable) {
        return new Page<LossType>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public LossType save(@RequestBody LossType lossType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            lossType = service.save(lossType);
            return lossType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LossTypeView.All.class)
    @GetMapping("/{id}")
    public LossType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(LossTypeView.All.class)
    @PutMapping("/{id}")
    public LossType updateCustomer(@PathVariable int id, @RequestBody LossType lossType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossType.setId(id);
        lossType = service.save(lossType);
        return lossType;
    }
}
