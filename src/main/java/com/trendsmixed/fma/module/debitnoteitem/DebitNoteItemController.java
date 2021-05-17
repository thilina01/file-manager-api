package com.trendsmixed.fma.module.debitnoteitem;

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
@RequestMapping("/debitNoteItems")
public class DebitNoteItemController {

    
    private final DebitNoteItemService service;
    
    @JsonView(DebitNoteItemView.All.class)
    @GetMapping
    public Iterable<DebitNoteItem> findAll() {
        return service.findAll();
    }

    @JsonView(DebitNoteItemView.All.class)
    @GetMapping("/page")
    Page<DebitNoteItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<DebitNoteItem> debitNoteItemList) {
        try {
            service.save(debitNoteItemList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public DebitNoteItem save(@RequestBody DebitNoteItem debitNoteItem) {
        
        try {
            debitNoteItem = service.save(debitNoteItem);
            return debitNoteItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DebitNoteItemView.All.class)
    @GetMapping("/{id}")
    public DebitNoteItem findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public DebitNoteItem updateCustomer(@PathVariable int id, @RequestBody DebitNoteItem debitNoteItem) {
        
        debitNoteItem.setId(id);
        debitNoteItem = service.save(debitNoteItem);
        return debitNoteItem;
    }
}
