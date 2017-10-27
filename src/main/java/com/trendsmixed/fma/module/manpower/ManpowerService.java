package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ManpowerService {

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

    public List<Manpower> findByProduction(Production production) {
        return repository.findByProduction(production);
    }

}
