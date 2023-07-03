package com.unicauca.openmarketms.domain.service.User;

import com.unicauca.openmarketms.access.repository.IPersonRepository;
import com.unicauca.openmarketms.domain.entity.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements  IPersonService{

    @Autowired
    private IPersonRepository personRepository;
    @Override
    public Person login(String email, String password) {
        Person person = null;
        person = personRepository.findPersonByEmailAndPassword(email, password);
        return person;
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }
}
