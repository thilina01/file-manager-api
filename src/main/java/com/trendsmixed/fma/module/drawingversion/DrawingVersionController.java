package com.trendsmixed.fma.module.drawingversion;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/drawingVersions")
public class DrawingVersionController {

    
    private final DrawingVersionService service;

    @GetMapping
    @JsonView(DrawingVersionView.AllAndDrawingChangeRequestAndItem.class)
    public Iterable<DrawingVersion> findAll() {
        return service.findAll();
    }

    @JsonView(DrawingVersionView.AllAndDrawingChangeRequestAndItem.class)
    @GetMapping("/page")
    Page<DrawingVersion> page(Pageable pageable) {
        return new Page<DrawingVersion>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    
    @GetMapping("/latestByVersion")
    public DrawingVersion getLatestByVersion(
    @RequestParam(value = "itemId") String itemId) {
        return service.findFirstByItemOrderByVersionDesc(new Item(Integer.valueOf(itemId)));
    }


    @PostMapping
    @JsonView(DrawingVersionView.AllAndDrawingChangeRequestAndItem.class)
    public DrawingVersion save(@RequestBody DrawingVersion drawingVersion) {
        
        try {
           drawingVersion = service.save(drawingVersion);
            return drawingVersion;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<DrawingVersion>drawingVersions) {

        
        try {
            service.save( drawingVersions);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DrawingVersionView.AllAndDrawingChangeRequestAndItem.class)
    @GetMapping("/{id}")
    public DrawingVersion findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @JsonView(DrawingVersionView.AllAndDrawingChangeRequestAndItem.class)
    @PutMapping("/{id}")
    public DrawingVersion updateCustomer(@PathVariable int id, @RequestBody DrawingVersion drawingVersion) {
       drawingVersion.setId(id);
       drawingVersion = service.save(drawingVersion);
        return drawingVersion;
    }

}
