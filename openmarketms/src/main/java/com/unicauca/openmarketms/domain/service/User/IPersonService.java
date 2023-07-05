package com.unicauca.openmarketms.domain.service.User;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import java.util.List;

public interface IPersonService {
    
     List<Person> getAllPersons();

    Person getPersonById(Long id);

    void createPerson(Person person);

    void updatePerson(Long id, Person updatedPerson);

    void deletePerson(Long id);
}
