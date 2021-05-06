package com.trendsmixed.fma.module.itemsegment;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/itemSegments")
public class ItemSegmentController {

    
    private final ItemSegmentService service;

    @JsonView(ItemSegmentView.All.class)
    @GetMapping
    public Iterable<ItemSegment> findAll() {
        return service.findAll();
    }

    @JsonView(ItemSegmentView.All.class)
    @GetMapping("/page")
    Page<ItemSegment> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ItemSegmentView.All.class)
    @PostMapping
    public ItemSegment save(@RequestBody ItemSegment itemSegment) {
        
        try {
            itemSegment = service.save(itemSegment);
            return itemSegment;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ItemSegmentView.All.class)
    @GetMapping("/{id}")
    public ItemSegment findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public ItemSegment updateCustomer(@PathVariable int id, @RequestBody ItemSegment itemSegment) {
        
        itemSegment.setId(id);
        itemSegment = service.save(itemSegment);
        return itemSegment;
    }

}
