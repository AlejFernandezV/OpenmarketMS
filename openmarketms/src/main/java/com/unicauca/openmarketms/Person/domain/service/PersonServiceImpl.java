package com.unicauca.openmarketms.Person.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketms.Person.access.repository.IPersonRepository;
import com.unicauca.openmarketms.Person.domain.entity.Person;

@Service
public class PersonServiceImpl implements IPersonService{
    @Autowired
    private IPersonRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return (List<Person>) repository.findAll();
    }
    @Override
    public Person find(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public Person create(Person object) {
       return repository.save(object);
    }
    @Override
    public Person update(Long id, Person p) {
        Person personUpdate = this.find(id);
        personUpdate.setEmail(p.getEmail());
        personUpdate.setPassword(p.getPassword());
        return repository.save(personUpdate);
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Person login(String email, String password) {
        Person person = repository.findPersonByEmailAndPassword(email, password);
        return person;
    }
}
