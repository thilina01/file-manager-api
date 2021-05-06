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

    public Delivery findById(int id) {
        return deliveryRepository.findById(id).get();
    }

    public void deleteById(int id) {
        deliveryRepository.deleteById(id);
    }
}
