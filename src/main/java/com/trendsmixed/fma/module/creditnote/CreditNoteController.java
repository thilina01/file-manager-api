package com.trendsmixed.fma.module.creditnote;

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
@RequestMapping("/creditNotes")
public class CreditNoteController {

    private final CreditNoteService service;
    

    @PostMapping
    @JsonView(CreditNoteView.AllAndInvoice.class)
    public CreditNote save(@RequestBody CreditNote creditNote) {
        
        try {
            creditNote = service.save(creditNote);
            return creditNote;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(CreditNoteView.AllAndInvoice.class)
    public Iterable<CreditNote> findAll() {
        return service.findAll();
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    @JsonView(CreditNoteView.AllAndInvoice.class)
    @GetMapping("/page")
    public Page<CreditNote> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @JsonView(CreditNoteView.AllAndInvoice.class)
    public CreditNote findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(CreditNoteView.AllAndInvoice.class)
    public CreditNote update(@PathVariable int id, @RequestBody CreditNote creditNote) {
        
        creditNote.setId(id);
        creditNote = service.save(creditNote);
        return creditNote;
    }
}
