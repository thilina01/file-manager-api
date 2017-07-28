package com.trendsmixed.fma.module.lossreason;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.losstype.LossTypeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/lossReasons")
public class LossReasonController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private LossReasonService lossReasonService;
    @Autowired
    private LossTypeService lossTypeService;

    @JsonView(LossReasonView.AllAndLossTypeAll.class)
    @GetMapping
    public List<LossReason> findAll() {
        return lossReasonService.findAll();
    }

    @JsonView(LossReasonView.All.class)
    @PostMapping
    public LossReason save(@RequestBody LossReason lossReason, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            lossReason = lossReasonService.save(lossReason);
            return lossReason;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LossReason> lossReasons, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (LossReason lossReason : lossReasons) {
                LossType lossType = lossReason.getLossType();
                lossType = lossTypeService.findByCode(lossType.getCode());
                lossReason.setLossType(lossType);
                LossReason existingLossReason = lossReasonService.findByCode(lossReason.getCode());
                if(existingLossReason!=null){
                lossReason.setId(existingLossReason.getId());
                }
            }
            lossReasonService.save(lossReasons);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public LossReason findOne(@PathVariable("id") int id) {
        return lossReasonService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossReasonService.delete(id);

    }

    @PutMapping("/{id}")
    public LossReason updateCustomer(@PathVariable int id, @RequestBody LossReason lossReason, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossReason.setId(id);
        lossReason = lossReasonService.save(lossReason);
        return lossReason;
    }
}
