package com.unicauca.openmarketms.presentation.rest.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import com.unicauca.openmarketms.domain.service.User.IPersonService;

import io.swagger.annotations.ApiOperation;

public class PersonController {
    @Autowired
    private IPersonService personService;

    /**
     * Permite el login de una persona 
     * 
     * @param email
     * @param password
     * @return
     */
    @ApiOperation("Permite el login de una persona")
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public Person login(@PathVariable String email, @PathVariable String password){
        return personService.login(email, password);
    }
}
