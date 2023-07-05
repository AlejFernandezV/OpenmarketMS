package com.unicauca.openmarketms.domain.service.User;

import com.unicauca.openmarketms.domain.entity.Person.Person;
import com.unicauca.openmarketms.domain.service.IService;


public interface IPersonService extends IService <Person>{
    /**
     * Logueo del usuario
     * @param email email del usuario
     * @param password contraseña del usuario
     * @return Objeto persona si el logueo es exitoso, null de lo contrario
     */
    public Person login(String email, String password);
}
