package com.trendsmixed.fma.module.ontimedelivery;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        repository.save(onTimeDeliveries);
    }

    public OnTimeDelivery findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
