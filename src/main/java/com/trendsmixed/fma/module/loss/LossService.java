package com.trendsmixed.fma.module.loss;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LossService {

    private LossRepository lossRepository;

    public List<Loss> findAll() {
        return lossRepository.findAll();
    }

    public Loss save(Loss loss) {
        return lossRepository.save(loss);
    }

    public void save(List<Loss> losses) {
        lossRepository.saveAll(losses);
    }

    public Loss findById(int id) {
        return lossRepository.findById(id).get();
    }

    public void deleteById(int id) {
        lossRepository.deleteById(id);
    }

}
