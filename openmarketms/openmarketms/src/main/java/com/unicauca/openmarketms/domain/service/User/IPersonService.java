package com.unicauca.openmarketms.domain.service.User;

import com.unicauca.openmarketms.domain.entity.Person.Person;

public interface IPersonService {
    /**
     * Logueo del usuario
     * @param email email del usuario
     * @param password contraseña del usuario
     * @return Objeto persona si el logueo es exitoso, null de lo contrario
     */
    public Person login(String email, String password);

    /**
     * Creación de un nuevo usuario
     * @param person Objeto persona a crear
     * @return Objeto persona creado
     */
    public Person create(Person person);
}
