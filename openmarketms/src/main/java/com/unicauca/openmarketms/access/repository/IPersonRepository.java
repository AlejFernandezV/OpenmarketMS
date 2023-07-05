package com.unicauca.openmarketms.access.repository;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import java.util.List;

public interface IPersonRepository {
    
    public List<Person> findByName(String name);
    
    public List<Person> findByID(Long name);

    public List<Person> findAll();

    public Person findById(Long id);

    public void save(Person person);

    public void deleteById(Long id);

    /**
     * Busca una persona por su email y password
     * @param email email
     * @param password password
     * @return persona
     */
    public Person findPersonByEmailAndPassword(String email, String password);

}
