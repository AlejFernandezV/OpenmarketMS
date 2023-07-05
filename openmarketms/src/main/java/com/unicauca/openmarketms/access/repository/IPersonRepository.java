package com.unicauca.openmarketms.access.repository;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Long>{
    
    public List<Person> findByName(String name);
    
    public List<Person> findByID(Long name);

    public List<Person> findAll();

    /**
     * Busca una persona por su email y password
     * @param email email
     * @param password password
     * @return persona
     */
    public Person findPersonByEmailAndPassword(String email, String password);

}
