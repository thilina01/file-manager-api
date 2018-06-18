package com.trendsmixed.fma.module.paint;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/paints")
public class PaintController {

    
    private final PaintService service;

    @JsonView(PaintView.All.class)
    @GetMapping
    public Iterable<Paint> findAll() {
        return service.findAll();
    }

    @JsonView(PaintView.All.class)
    @GetMapping("/page")
    Page<Paint> page(Pageable pageable) {
        return new Page<Paint>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PaintView.All.class)
    @PostMapping
    public Paint save(@RequestBody Paint paint, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        try {
            paint = service.save(paint);
            return paint;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Paint> paints,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(paints);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PaintView.All.class)
    @GetMapping("/{id}")
    public Paint findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @JsonView(PaintView.All.class)
    @PutMapping("/{id}")
    public Paint updateCustomer(@PathVariable int id, @RequestBody Paint paint,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        paint.setId(id);
        paint = service.save(paint);
        return paint;
    }
}
