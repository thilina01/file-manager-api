package com.trendsmixed.fma.module.ontimedelivery;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OnTimeDeliveryService {

    private OnTimeDeliveryRepository repository;

    public Iterable<OnTimeDelivery> findAll() {
        return repository.findAll();
    }

    public Page<OnTimeDelivery> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
    }

    public OnTimeDelivery save(OnTimeDelivery onTimeDelivery) {
        return repository.save(onTimeDelivery);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public void save(List<OnTimeDelivery> onTimeDeliveries) {
        repository.saveAll(onTimeDeliveries);
    }

    public OnTimeDelivery findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
