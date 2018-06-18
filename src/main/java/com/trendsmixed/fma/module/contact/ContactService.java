package com.trendsmixed.fma.module.contact;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactService {

    private ContactRepository repository;

    public Iterable<Contact> findAll() {
        return repository.findAll();
    }

    public Page<Contact> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public Contact findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
