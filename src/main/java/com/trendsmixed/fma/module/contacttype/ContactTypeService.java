package com.trendsmixed.fma.module.contacttype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public void save(List<ContactType> countries) {
        repository.save(countries);
    }

    public ContactType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ContactType findByCode(String code) {
        return repository.findByCode(code);
    }

    public ContactType findByName(String name) {
        return repository.findByName(name);
    }
}
