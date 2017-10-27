package com.trendsmixed.fma.module.delivery;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
