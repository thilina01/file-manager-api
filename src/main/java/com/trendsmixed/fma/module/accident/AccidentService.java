package com.trendsmixed.fma.module.accident;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import java.util.Date;
import lombok.AllArgsConstructor;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccidentService {

    private AccidentRepository repository;

    public Iterable<Accident> findAll() {
        return repository.findAll();
    }

    public Page<Accident> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Accident save(Accident accident) {
        return repository.save(accident);
    }

    public Accident findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Accident findByCode(String code) {
        return repository.findByCode(code);
    }

    public Page<Accident> findByAccidentDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return repository.findByAccidentDateBetween(startDate, endDate, pageable);
    }

    public Page<Accident> findByAccidentDateAndSection(Date date, Section section, Pageable pageable) {
        return repository.findByAccidentDateAndSection(date, section, pageable);
    }

    public Page<Accident> findBySectionAndAccidentDateBetween(Section section, Date startDate, Date endDate, Pageable pageable) {
        return repository.findBySectionAndAccidentDateBetween(section, startDate, endDate, pageable);
    }

    public Page<Accident> findByAccidentDateAndEmployee(Date date, Employee employee, Pageable pageable) {
        return repository.findByAccidentDateAndEmployee(date, employee, pageable);
    }

    public Page<Accident> findByEmployeeAndAccidentDateBetween(Employee employee, Date startDate, Date endDate, Pageable pageable) {
        return repository.findByEmployeeAndAccidentDateBetween(employee, startDate, endDate, pageable);
    }
   
}
