package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.entity.Section;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.SectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public Section save(@RequestBody Section section, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
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
    }

    @GetMapping
    public List<Section> findAll() {
        return sectionService.findAll();
    }

    @GetMapping("/{id}")
    public Section findOne(@PathVariable("id") int id) {
        return sectionService.findOne(id);
    }
}
