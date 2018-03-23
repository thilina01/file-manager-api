package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoadingPlanItemService {

    private LoadingPlanItemRepository repository;

    public Iterable<LoadingPlanItem> findAll() {
        return repository.findAll();
    }

    public Page<LoadingPlanItem> findAll(Pageable pageable) {
        return new Page<LoadingPlanItem>(repository.findAll(pageable));
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public LoadingPlanItem save(LoadingPlanItem loadingPlanItem) {
        return repository.save(loadingPlanItem);
    }

    public LoadingPlanItem findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
