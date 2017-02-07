package com.trendsmixed.fma.module.losstype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.LossType;
import com.trendsmixed.fma.module.losstype.LossTypeView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
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
@RequestMapping("/lossTypes")
public class LossTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private LossTypeService lossTypeService;

    @JsonView(LossTypeView.AlLAndLossReasonList.class)
    @GetMapping
    public List<LossType> findAll() {
        return lossTypeService.findAll();
    }

    @PostMapping
    public LossType save(@RequestBody LossType lossType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            lossType = lossTypeService.save(lossType);
            return lossType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public LossType findOne(@PathVariable("id") int id) {
        return lossTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public LossType updateCustomer(@PathVariable int id, @RequestBody LossType lossType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossType.setId(id);
        lossType = lossTypeService.save(lossType);
        return lossType;
    }
}
