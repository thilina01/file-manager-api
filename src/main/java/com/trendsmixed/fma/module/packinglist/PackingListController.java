package com.trendsmixed.fma.module.packinglist;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.trendsmixed.fma.utility.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.invoice.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/packingLists")
public class PackingListController {

    private final AppSessionService appSessionService;
    private final PackingListService service;

    @JsonView(PackingListView.AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll.class)
    @GetMapping
    public Iterable<PackingList> findAll() {
        return service.findAll();
    }

    @JsonView(PackingListView.AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll.class)
    @GetMapping("/page")
    Page<PackingList> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PackingListView.AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll.class)
    @GetMapping("/id/{id}")
    public PackingList findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @JsonView(PackingListView.AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll.class)
    @PostMapping
    public PackingList save(@RequestBody PackingList packingList, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<Invoice> invoices = packingList.getInvoiceList();
            if (invoices != null) {
                for (Invoice invoice : invoices) {
                    invoice.setPackingList(packingList);
                    packingList = service.save(packingList);
                }
            }
            return packingList;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<PackingList> packingLists, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PackingListView.AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll.class)
    @GetMapping("/{id}")
    public PackingList findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(PackingListView.AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll.class)
    @PutMapping("/{id}")
    public PackingList updateCustomer(@PathVariable int id, @RequestBody PackingList packingList, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        packingList.setId(id);
        packingList = service.save(packingList);
        return packingList;
    }

}
