package com.trendsmixed.fma.module.creditnote;
import com.trendsmixed.fma.dao.view.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.creditnoteitem.CreditNoteItem;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.text.ParseException;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/creditNotes")
public class CreditNoteController {

    private final CreditNoteService service;

    
    @GetMapping("/page")
    Page<CreditNote> page(Pageable pageable) {
         return new Page<>(service.findAll(pageable));
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
    @JsonView(CreditNoteView.AllAndCreditNoteItemAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndLoadingPlanAndAddressAndCustomerAndCountryAndIncotermAndCurrencyAndNotifyPartyAndContactAndPaymentTermAndEmployee.class)
    @GetMapping("/{id}")
    public CreditNote findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @JsonView(CreditNoteReportView.All.class)
    @GetMapping("/creditNoteDetails")
    public Page<CreditNote> getCreditNoteDetails(
            @RequestParam(value = "startDate",required = false, defaultValue = "1970-01-01") String startDate,
            @RequestParam(value = "endDate",required = false, defaultValue = "2100-12-31") String endDate,
            Pageable pageable) throws ParseException{
            Page<CreditNote> page;
            return new Page(service.getCreditNoteByDateBetween(Format.toStartDate(startDate), Format.toEndDate(endDate), pageable));
    }

    @PostMapping
    @JsonView(CreditNoteView.AllAndInvoice.class)
    public CreditNote save(@RequestBody CreditNote creditNote) {
        
        List<CreditNoteItem> creditNoteItems = creditNote.getCreditNoteItemList();
        if (creditNoteItems != null) {
            for (CreditNoteItem creditNoteItem : creditNoteItems) {
                creditNoteItem.setCreditNote(creditNote);
            }
        }

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
