package com.trendsmixed.fma.module.item;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.itemtype.ItemType;
import com.trendsmixed.fma.module.paint.Paint;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.itemtype.ItemTypeService;
import com.trendsmixed.fma.module.paint.PaintService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    private AppSessionService appSessionService;
    private ItemService service;
    private ItemTypeService itemTypeService;
    private PaintService paintService;

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping
    public Iterable<Item> findAll() {
        return service.findAll();
    }

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping("/page")
    Page<Item> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @PostMapping
    public Item save(@RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            if (item.getId() == null && service.findByCode(item.getCode()) != null) {
                throw new Error("Already Exists [ " + item.getCode() + " ]");
            }
            item = service.save(item);
            return item;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Item> items, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            for (Item item : items) {
                String code = item.getCode();
                if (code == null) {
                    continue;
                }
                String description = item.getDescription();
                if (description == null) {
                    continue;
                }
                item.setCode(code.trim());
                item.setDescription(description.trim());
                Item existingItem = service.findByCode(code.trim());
                if (existingItem != null) {
                    //itemsToRemove.add(item);
                    item.setId(existingItem.getId());
                }

                ItemType itemType = item.getItemType();
                if (itemType != null) {
                    String name = itemType.getName().trim();
                    ItemType existingItemType = itemTypeService.findByName(name);
                    if (existingItemType == null) {
                        existingItemType = new ItemType();
                        existingItemType.setCode(name);
                        existingItemType.setName(name);
                        existingItemType = itemTypeService.save(itemType);
                    }
                    item.setItemType(existingItemType);
                }

                Paint paint = item.getPaint();
                if (paint != null) {
                    String paintCode = paint.getCode();
                    String paintName = paint.getName();
                    if (paintCode != null) {
                        paint = paintService.findByCode(paintCode);
                    } else if (paintName != null) {
                        paint = paintService.findByName(paintName);
                    }
                    if (paint == null) {
                        paint = paintService.findByCode("NA");
                        if (paint == null) {
                            paint = new Paint();
                            paint.setCode("NA");
                            paint = paintService.save(paint);
                        }

                    }
                    item.setPaint(paint);
                }
            }

            service.save(items);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping("/{id}")
    public Item findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Item update(@PathVariable int id, @RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        item.setId(id);
        item = service.save(item);
        return item;
    }
}
