package com.trendsmixed.fma.module.debitnote;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.debitnoteitem.DebitNoteItem;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/debitNotes")
public class DebitNoteController {

    private final DebitNoteService service;
    
    @GetMapping
    @JsonView(DebitNoteView.AllAndInvoice.class)
    public Iterable<DebitNote> findAll() {
        return service.findAll();
    }

    @JsonView(DebitNoteView.AllAndInvoice.class)
    @GetMapping("/page")
    public Page<DebitNote> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
   
    @PostMapping
    @JsonView(DebitNoteView.AllAndInvoice.class)
    public DebitNote save(@RequestBody DebitNote debitNote) {

        List<DebitNoteItem> debitNoteItems = debitNote.getDebitNoteItemList();
        if (debitNoteItems != null) {
            for (DebitNoteItem debitNoteItem : debitNoteItems) {
                debitNoteItem.setDebitNote(debitNote);
            }
        }

        try {
            debitNote = service.save(debitNote);
            return debitNote;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(DebitNoteView.AllAndInvoice.class)
    public DebitNote findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    @JsonView(DebitNoteView.AllAndInvoice.class)
    public DebitNote update(@PathVariable int id, @RequestBody DebitNote debitNote) {
        
        debitNote.setId(id);
        debitNote = service.save(debitNote);
        return debitNote;
    }
}
