package com.unicauca.openmarketms.domain.service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketms.access.repository.IPersonRepository;
import com.unicauca.openmarketms.domain.entity.Person.Person;

public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonRepository repository;

    /**
     * Permite el login de las personas
     * 
     * @param email
     * @param password
     * @return persona logueada
    */
    @Override
    public Person login(String email, String password) {
        Person person = repository.findPersonByEmailAndPassword(email, password);
        return person;
    }

    /**
     * Encuentra a todas las personas
     * 
     * @return lista de todas las personas encontradas
     */
    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return (List<Person>) repository.findAll();
    }

    /**
     * Busca las personas por ID
     * 
     * @param id
     * @return persona encontrada
     */
    @Override
    public Person find(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Crea persona(usuario)
     * 
     * @param object
     * @return persona creada
     */
    @Override
    @Transactional
    public Person create(Person object) {
       return repository.save(object);
    }

    /**
     * Actualiza una persona
     * 
     * @param id
     * @param p
     * @return persona actualizada
     */
    @Override
    public Person update(Long id, Person p) {
        Person personUpdate = this.find(id);
        personUpdate.setEmail(p.getEmail());
        personUpdate.setPassword(p.getPassword());
        return repository.save(personUpdate);
    }

    /**
     * Elimina una persona
     * 
     * @param id
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
