package com.trendsmixed.fma.module.delivery;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;

    public List< Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery findOne(int id) {
        return deliveryRepository.findOne(id);
    }

    public void delete(int id) {
        deliveryRepository.delete(id);
    }
}
