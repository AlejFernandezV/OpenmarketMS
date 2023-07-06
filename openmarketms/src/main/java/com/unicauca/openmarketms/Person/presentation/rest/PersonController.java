package com.unicauca.openmarketms.Person.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.openmarketms.Person.domain.entity.Person;
import com.unicauca.openmarketms.Person.domain.service.IPersonService;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public Person login(String email, String password){
        return personService.login(email, password);
    }

    /**
     * Busca todos las personas
     * 
     * @return Lista de personas
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Person> findAll(){
        return(List<Person>) personService.findAll();
    }    

    /**
     * Busca una persona por su id
     * 
     * @param id id de la persona
     * @return persona
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Person findById(@PathVariable Long id) {
        return personService.find(id);
    }

    /**
     * Crea una persona
     * 
     * @param person persona a crear
     * @return persona creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    /**
     * Actualiza una persona
     * 
     * @param person persona a actualizar
     * @param id      id de la persona a actualizar
     * @return persona actualizada
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Person update(@RequestBody Person person, @PathVariable Long id) {
        return personService.update(id, person);
    }

    /**
     * Elimina una persona
     * 
     * @param id id de la persona a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
