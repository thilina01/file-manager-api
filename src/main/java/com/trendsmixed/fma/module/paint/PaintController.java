package com.trendsmixed.fma.module.paint;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Paint;
import com.trendsmixed.fma.module.paint.PaintView;
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

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Paint> paints, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            paintService.save(paints);
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
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        paintService.delete(id);

    }

    @PutMapping("/{id}")
    public Paint updateCustomer(@PathVariable int id, @RequestBody Paint paint, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        paint.setId(id);
        paint = paintService.save(paint);
        return paint;
    }
}