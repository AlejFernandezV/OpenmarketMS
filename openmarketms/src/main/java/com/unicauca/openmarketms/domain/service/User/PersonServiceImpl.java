package com.unicauca.openmarketms.domain.service.User;

public class PersonServiceImpl {
    @Autowired
    private IPersonRepository personRepository;
    @Override
    public Person login(String email, String password) {
        Person person = null;
        person = personRepository.findPersonByEmailAndPassword(email, password);
        return person;
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }
}
