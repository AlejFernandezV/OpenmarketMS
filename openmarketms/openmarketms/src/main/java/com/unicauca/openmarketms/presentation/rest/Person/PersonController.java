package com.unicauca.openmarketms.presentation.rest.Person;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import com.unicauca.openmarketms.domain.service.User.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public Person login(String email, String password){
        return personService.login(email, password);
    }
}
