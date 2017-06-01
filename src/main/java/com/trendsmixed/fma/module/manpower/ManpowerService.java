package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.entity.Manpower;
import com.trendsmixed.fma.utility.Page;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ManpowerService {

    @Autowired
    private ManpowerRepository repository;

    public Iterable<Manpower> findAll() {
        return repository.findAll();
    }

    public Page<Manpower> findAll(Pageable pageable) {
        return new Page<>(repository.findAll(pageable));
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

}
