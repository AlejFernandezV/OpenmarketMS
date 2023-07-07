package com.unicauca.openmarketms.Person.domain.service;

import com.unicauca.openmarketms.Commons.IService;
import com.unicauca.openmarketms.Person.domain.entity.Person;

public interface IPersonService extends IService <Person>{
    /**
     * Logueo del usuario
     * @param email email del usuario
     * @param password contraseña del usuario
     * @return Objeto persona si el logueo es exitoso, null de lo contrario
     */
    public Person login(String email, String password);
}
