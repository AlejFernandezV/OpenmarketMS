package com.unicauca.openmarketms.access.repository;

public interface IPersonRepository {
    /**
     * Busca una persona por su email y password
     * @param email email
     * @param password password
     * @return persona
     */
    public Person findPersonByEmailAndPassword(String email, String password);
}
