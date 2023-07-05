package com.unicauca.openmarketms.domain.service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.unicauca.openmarketms.access.repository.IPersonRepository;
import com.unicauca.openmarketms.domain.entity.Person.Person;

public class PersonServiceImpl implements IPersonService{
    @Autowired
    private IPersonRepository personRepository;
    @Override
    public Person login(String email, String password) {
        Person person = null;
        person = personRepository.findPersonByEmailAndPassword(email, password);
        return person;
    }
    @Override
    public List<Person> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    @Override
    public Person find(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
    @Override
    public Person create(Person object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Person update(Long id, Person object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
