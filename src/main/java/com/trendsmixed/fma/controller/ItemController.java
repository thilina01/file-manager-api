package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.Item;
import com.trendsmixed.fma.entity.ItemType;
import com.trendsmixed.fma.entity.Paint;
import com.trendsmixed.fma.jsonView.ItemView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ItemService;
import com.trendsmixed.fma.service.ItemTypeService;
import com.trendsmixed.fma.service.PaintService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemTypeService itemTypeService;
    @Autowired
    private PaintService paintService;

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @PostMapping
    public Item save(@RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            item = itemService.save(item);
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
            //List<Item> itemsToRemove = new ArrayList<>();
            for (Item item : items) {
                item.setCode(item.getCode().trim());
                item.setDescription(item.getDescription().trim());
                Item existingItem = itemService.findByCode(item.getCode());
                if (existingItem != null) {
                    //itemsToRemove.add(item);
                    item.setId(existingItem.getId());
                }

                ItemType itemType = item.getItemType();
                if (itemType != null) {
                    itemType = itemTypeService.findByType(itemType.getType());
                    item.setItemType(itemType);
                }

                Paint paint = item.getPaint();
                if (paint != null) {
                    paint = paintService.findByCode(paint.getCode());
                    item.setPaint(paint);
                }
            }
            /*System.out.println(items.size());
            System.out.println(itemsToRemove.size());
            for (Item item : itemsToRemove) {
                System.out.println(item.getCode());
                Predicate<Item> itemPredicate = i -> i.getCode() == item.getCode();
                items.removeIf(itemPredicate);
            }
            System.out.println(items.size());
            //items.removeAll(itemsToRemove);*/
            itemService.save(items);
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
        return itemService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        itemService.delete(id);

    }

    @PutMapping("/{id}")
    public Item updateCustomer(@PathVariable int id, @RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        item.setId(id);
        item = itemService.save(item);
        return item;
    }
}
