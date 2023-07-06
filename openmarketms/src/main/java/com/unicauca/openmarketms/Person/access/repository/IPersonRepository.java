package com.unicauca.openmarketms.Person.access.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarketms.Person.domain.entity.Person;

public interface IPersonRepository extends CrudRepository<Person, Long>{
    public List<Person> findByName(String name);

    public Person findPersonByEmailAndPassword(String email,String password);
}

