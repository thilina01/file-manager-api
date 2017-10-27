package com.trendsmixed.fma.module.lossreason;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.losstype.LossTypeService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/lossReasons")
public class LossReasonController {

    private final AppSessionService appSessionService;
    private final LossReasonService service;
    private final LossTypeService lossTypeService;

    @JsonView(LossReasonView.AllAndLossTypeAll.class)
    @GetMapping
    public Iterable<LossReason> findAll() {
        return service.findAll();
    }

    @JsonView(LossReasonView.All.class)
    @GetMapping("/page")
    Page<LossReason> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(LossReasonView.All.class)
    @PostMapping("/pageByLossType")
    Page<LossReason> pageByLossType(Pageable pageable, @RequestBody LossType lossType) {
        if (lossType.getId() == null) {
            lossType = lossTypeService.findByCode(lossType.getCode());
        }
        return new Page<>(service.findByLossType(lossType, pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping("/comboByLossType")
    List<Combo> comboByLossType(@RequestBody LossType lossType) {
        if (lossType.getId() == null) {
            lossType = lossTypeService.findByCode(lossType.getCode());
        }
        return service.getComboByLossType(lossType);
    }

    @JsonView(LossReasonView.All.class)
    @PostMapping
    public LossReason save(@RequestBody LossReason lossReason, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            lossReason = service.save(lossReason);
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
                LossReason existingLossReason = service.findByCode(lossReason.getCode());
                if (existingLossReason != null) {
                    lossReason.setId(existingLossReason.getId());
                }
            }
            service.save(lossReasons);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LossReasonView.AllAndLossTypeAll.class)
    @GetMapping("/{id}")
    public LossReason findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(LossReasonView.All.class)
    @PutMapping("/{id}")
    public LossReason updateCustomer(@PathVariable int id, @RequestBody LossReason lossReason, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossReason.setId(id);
        lossReason = service.save(lossReason);
        return lossReason;
    }
}
