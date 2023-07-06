package com.unicauca.openmarketms.access.repository;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "Person Repository")
public interface IPersonRepository extends CrudRepository<Person, Long> {

    @ApiOperation("Buscar personas por nombre")
    @GetMapping("/persons")
    public List<Person> findByName(@RequestParam("name") String name);

    @ApiOperation("Buscar persona por ID")
    @GetMapping("/persons/{id}")
    public Person findByID(@PathVariable("id") Long id);

    @ApiOperation("Obtener todas las personas")
    @GetMapping("/persons/all")
    public List<Person> findAll();

    @ApiOperation("Buscar persona por email y contraseña")
    @GetMapping("/persons/login")
    public Person findPersonByEmailAndPassword(
            @ApiParam(value = "Email de la persona", required = true) @RequestParam("email") String email,
            @ApiParam(value = "Contraseña de la persona", required = true) @RequestParam("password") String password);
}
