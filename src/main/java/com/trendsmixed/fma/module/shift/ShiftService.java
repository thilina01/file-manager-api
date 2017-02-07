package com.trendsmixed.fma.module.shift;

import com.trendsmixed.fma.entity.Shift;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.module.shift.ShiftRepository;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> findAll() {
        return shiftRepository.findAll();
    }

    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }

    public Shift findOne(int id) {
        return shiftRepository.findOne(id);
    }

    public void delete(int id) {
        shiftRepository.delete(id);
    }

    public Shift findByCode(String code) {
        return shiftRepository.findByCode(code);
    }
}
