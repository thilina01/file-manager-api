package com.trendsmixed.fma.module.notifyparty;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NotifyPartyService {

    private NotifyPartyRepository repository;

    public Iterable<NotifyParty> findAll() {
        return repository.findAll();
    }

    public Page<NotifyParty> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public NotifyParty save(NotifyParty notifyParty) {
        return repository.save(notifyParty);
    }

    public NotifyParty findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public NotifyParty findByCode(String code) {
        return repository.findByCode(code);
    }

    public NotifyParty findByName(String name) {
        return repository.findByName(name);
    }
}
