package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.manpowertype.ManpowerType;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.shift.Shift;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ManpowerService {

    private ManpowerRepository repository;

    public Iterable<Manpower> findAll() {
        return repository.findAll();
    }

    public Page<Manpower> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Manpower save(Manpower manpower) {
        return repository.save(manpower);
    }

    public void save(List<Manpower> manpowers) {
        repository.save(manpowers);
    }

    public Manpower findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public List<Manpower> findByProduction(Production production) {
        return repository.findByProduction(production);
    }

    public Page<Manpower>findByProductionProductionDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionProductionDateBetween(startDate, endDate, pageable);
    }

    public Page<Manpower> findByProductionControlPointAndProductionProductionDateBetween(ControlPoint controlPoint, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionControlPointAndProductionProductionDateBetween(controlPoint, startDate, endDate, pageable);
    }

    public Page<Manpower> findByManpowerTypeAndProductionProductionDateBetween(ManpowerType manpowerType, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByManpowerTypeAndProductionProductionDateBetween(manpowerType, startDate, endDate, pageable);
    }

    public Page<Manpower> findByManpowerTypeAndProductionControlPointAndProductionProductionDateBetween(ManpowerType manpowerType,ControlPoint controlPoint, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByManpowerTypeAndProductionControlPointAndProductionProductionDateBetween(manpowerType,controlPoint, startDate, endDate, pageable);
    }

    public Page<Manpower> findByProductionShiftAndProductionProductionDateBetween(Shift shift, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionShiftAndProductionProductionDateBetween(shift, startDate, endDate, pageable);
    }

    public Page<Manpower> findByManpowerTypeAndProductionShiftAndProductionProductionDateBetween(ManpowerType manpowerType,Shift shift, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByManpowerTypeAndProductionShiftAndProductionProductionDateBetween(manpowerType,shift, startDate, endDate, pageable);
    }

    public Page<Manpower> findByProductionControlPointAndProductionShiftAndProductionProductionDateBetween(ControlPoint controlPoint,Shift shift, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByProductionControlPointAndProductionShiftAndProductionProductionDateBetween(controlPoint,shift, startDate, endDate, pageable);
    }
    
    public Page<Manpower> findByManpowerTypeAndProductionControlPointAndProductionShiftAndProductionProductionDateBetween(ManpowerType manpowerType,ControlPoint controlPoint,Shift shift, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByManpowerTypeAndProductionControlPointAndProductionShiftAndProductionProductionDateBetween(manpowerType,controlPoint,shift, startDate, endDate, pageable);
    }


    
    

}
