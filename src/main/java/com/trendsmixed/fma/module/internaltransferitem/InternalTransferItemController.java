package com.trendsmixed.fma.module.internaltransferitem;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/internalTransferItems")
public class InternalTransferItemController {

    private final InternalTransferItemService service;

    @JsonView(InternalTransferItemView.All.class)
    @GetMapping
    public Iterable<InternalTransferItem> findAll() {
        return service.findAll();
    }

    @JsonView(InternalTransferItemView.All.class)
    @GetMapping("/page")
    Page<InternalTransferItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<InternalTransferItem> internalTransferItemList) {

        try {

            service.save(internalTransferItemList);
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
    @JsonView(InternalTransferItemView.All.class)
    @PostMapping
    public InternalTransferItem save(@RequestBody InternalTransferItem internalTransferItem) {
        try {
            internalTransferItem = service.save(internalTransferItem);
            return internalTransferItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InternalTransferItemView.All.class)
    @GetMapping("/{id}")
    public InternalTransferItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public InternalTransferItem updateCustomer(@PathVariable int id, @RequestBody InternalTransferItem internalTransferItem) {
        internalTransferItem.setId(id);
        internalTransferItem = service.save(internalTransferItem);
        return internalTransferItem;
    }
}
