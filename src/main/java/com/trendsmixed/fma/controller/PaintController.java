package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Paint;
import com.trendsmixed.fma.jsonView.PaintView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.PaintService;
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
@RequestMapping("/paints")
public class PaintController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private PaintService paintService;

    @JsonView(PaintView.All.class)
    @GetMapping
    public List<Paint> findAll() {
        return paintService.findAll();
    }

    @JsonView(PaintView.All.class)
    @PostMapping
    public Paint save(@RequestBody Paint paint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            paint = paintService.save(paint);
            return paint;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Paint findOne(@PathVariable("id") int id) {
        return paintService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        paintService.delete(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public Paint updateCustomer(@PathVariable int id, @RequestBody Paint paint) {
        paint.setId(id);
        paint = paintService.save(paint);
        return paint;
    }
}
