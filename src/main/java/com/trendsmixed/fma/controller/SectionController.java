package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.entity.Section;
import com.trendsmixed.fma.jsonView.SectionView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.SectionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

@RestController
@CrossOrigin
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;
    @Autowired
    private AppSessionService appSessionService;

    public boolean isValid(String email, HttpServletRequest request) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Please Login");
        }
        if (!appSession.getIp().equals(request.getRemoteAddr())) {
            appSessionService.delete(email);
            throw new Error("Please Login");
        }
        if (appSession.getLastTime() < (System.currentTimeMillis() - (1000 * 60 * 10))) {
            appSessionService.delete(email);
            throw new Error("Please Login Again");
        }
        return true;
    }

    @PostMapping
    public Section save(@RequestBody Section section, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        isValid(email, request);
        try {
            section = sectionService.save(section);
            return section;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(SectionView.All.class)
    public List<Section> findAll() {
        return sectionService.findAll();
    }

    @GetMapping("/{id}")
    public Section findOne(@PathVariable("id") int id) {
        return sectionService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        sectionService.delete(id);
        return "Deleted";
    }

    @PutMapping("/{id}")
    public Section updateCustomer(@PathVariable int id, @RequestBody Section section) {
        section.setId(id);
        section = sectionService.save(section);
        return section;
    }
}
