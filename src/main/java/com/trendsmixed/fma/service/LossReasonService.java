package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.LossReason;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.LossReasonRepository;

@Service
public class LossReasonService {

    @Autowired
    private LossReasonRepository lossReasonRepository;

    public List<LossReason> findAll() {
        return lossReasonRepository.findAll();
    }

    public LossReason save(LossReason lossReason) {
        return lossReasonRepository.save(lossReason);
    }

    public void save(List<LossReason> lossReasons) {
        lossReasonRepository.save(lossReasons);
    }

    public LossReason findOne(int id) {
        return lossReasonRepository.findOne(id);
    }

    public void delete(int id) {
        lossReasonRepository.delete(id);
    }

    public LossReason findByCode(String code) {
        return lossReasonRepository.findByCode(code);
    }
}
