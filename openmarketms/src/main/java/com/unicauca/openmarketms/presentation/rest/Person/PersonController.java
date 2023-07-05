package com.unicauca.openmarketms.presentation.rest.Person;

public class PersonController {
    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public Person login(String email, String password){
        return personService.login(email, password);
    }
}
