package com.trendsmixed.fma.module.schedule;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScheduleService {

    private ScheduleRepository repository;

    public Iterable<Schedule> findAll() {
        return repository.findAll();
    }

    public Page<Schedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Schedule save(Schedule schedule) {
        return repository.save(schedule);
    }

    public void save(List<Schedule> schedules) {
        repository.saveAll(schedules);
    }

    public Schedule findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
