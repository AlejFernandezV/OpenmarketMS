package com.unicauca.openmarketms.access.repository;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long> {
    /**
     * Busca una persona por su email y password
     * @param email email
     * @param password password
     * @return persona
     */
    public Person findPersonByEmailAndPassword(String email, String password);
}
