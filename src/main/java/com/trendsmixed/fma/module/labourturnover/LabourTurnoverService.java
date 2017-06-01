package com.trendsmixed.fma.module.labourturnover;

import com.trendsmixed.fma.entity.LabourTurnover;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LabourTurnoverService {

    @Autowired
    private LabourTurnoverRepository labourTurnoverRepository;

    public List<LabourTurnover> findAll() {
        return labourTurnoverRepository.findAll();
    }

    public LabourTurnover save(LabourTurnover labourTurnover) {
        return labourTurnoverRepository.save(labourTurnover);
    }

    public void save(List<LabourTurnover> countries) {
        labourTurnoverRepository.save(countries);
    }

    public LabourTurnover findOne(int id) {
        return labourTurnoverRepository.findOne(id);
    }

    public void delete(int id) {
        labourTurnoverRepository.delete(id);
    }

}
