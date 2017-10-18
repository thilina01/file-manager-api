package com.trendsmixed.fma.module.loss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LossService {

    @Autowired
    private LossRepository lossRepository;

    public List<Loss> findAll() {
        return lossRepository.findAll();
    }

    public Loss save(Loss loss) {
        return lossRepository.save(loss);
    }

    public void save(List<Loss> losses) {
        lossRepository.save(losses);
    }

    public Loss findOne(int id) {
        return lossRepository.findOne(id);
    }

    public void delete(int id) {
        lossRepository.delete(id);
    }

}
