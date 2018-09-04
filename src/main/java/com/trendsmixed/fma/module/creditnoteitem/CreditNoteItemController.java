package com.trendsmixed.fma.module.creditnoteitem;

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
@RequestMapping("/creditNoteItems")
public class CreditNoteItemController {

    
    private final CreditNoteItemService service;
    
    @JsonView(CreditNoteItemView.All.class)
    @GetMapping
    public Iterable<CreditNoteItem> findAll() {
        return service.findAll();
    }

    @JsonView(CreditNoteItemView.All.class)
    @GetMapping("/page")
    Page<CreditNoteItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<CreditNoteItem> creditNoteItemList) {
        try {
            service.save(creditNoteItemList);
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
    public CreditNoteItem save(@RequestBody CreditNoteItem creditNoteItem) {
        
        try {
            creditNoteItem = service.save(creditNoteItem);
            return creditNoteItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CreditNoteItemView.All.class)
    @GetMapping("/{id}")
    public CreditNoteItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public CreditNoteItem updateCustomer(@PathVariable int id, @RequestBody CreditNoteItem creditNoteItem) {
        
        creditNoteItem.setId(id);
        creditNoteItem = service.save(creditNoteItem);
        return creditNoteItem;
    }
}
