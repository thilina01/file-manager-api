package com.trendsmixed.fma.module.dispatchschedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.utility.Page;

@Service
public class DispatchScheduleService {

    @Autowired
    private DispatchScheduleRepository repository;

    public Iterable<DispatchSchedule> findAll() {
        return repository.findAll();
    }

    public Page<DispatchSchedule> findAll(Pageable pageable) {
        return new Page<DispatchSchedule>(repository.findAll(pageable));
    }

    public DispatchSchedule save(DispatchSchedule dispatchSchedule) {
        return repository.save(dispatchSchedule);
    }

    public Iterable<DispatchSchedule> save(List<DispatchSchedule> dispatchSchedules) {
        return repository.save(dispatchSchedules);
    }

    public DispatchSchedule findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
