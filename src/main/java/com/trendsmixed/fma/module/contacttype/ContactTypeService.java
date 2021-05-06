package com.trendsmixed.fma.module.contacttype;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactTypeService {

    private ContactTypeRepository repository;

    public Iterable<ContactType> findAll() {
        return repository.findAll();
    }

    public Page<ContactType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public ContactType save(ContactType addressType) {
        return repository.save(addressType);
    }

    public void save(List<ContactType> contactTypes) {
        repository.saveAll(contactTypes);
    }

    public ContactType findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ContactType findByCode(String code) {
        return repository.findByCode(code);
    }

    public ContactType findByName(String name) {
        return repository.findByName(name);
    }
}
