package com.trendsmixed.fma.module.drawingversion;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DrawingVersionService {

    private DrawingVersionRepository repository;

    public Iterable<DrawingVersion> findAll() {
        return repository.findAll();
    }

    public Page<DrawingVersion> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public DrawingVersion save(DrawingVersion drawingVersion) {
        return repository.save(drawingVersion);
    }

    public void save(List<DrawingVersion>drawingVersions) {
        repository.save(drawingVersions);
    }

    public DrawingVersion findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public DrawingVersion findFirstByItemOrderByVersionDesc(Item item) {
        return repository.findFirstByItemOrderByVersionDesc(item);
    }
  
}
