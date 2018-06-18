package com.trendsmixed.fma.module.palletsize;

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
@RequestMapping("/palletSizes")
public class PalletSizeController {

    private final PalletSizeService service;
    

    @PostMapping
    @JsonView(PalletSizeView.All.class)
    public PalletSize save(@RequestBody PalletSize palletSize) {
        
        try {
            palletSize = service.save(palletSize);
            return palletSize;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(PalletSizeView.All.class)
    public Iterable<PalletSize> findAll() {
        return service.findAll();
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    @JsonView(PalletSizeView.All.class)
    @GetMapping("/page")
    public Page<PalletSize> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @JsonView(PalletSizeView.All.class)
    public PalletSize findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(PalletSizeView.All.class)
    public PalletSize update(@PathVariable int id, @RequestBody PalletSize palletSize) {
        
        palletSize.setId(id);
        palletSize = service.save(palletSize);
        return palletSize;
    }
}
