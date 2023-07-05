package com.unicauca.openmarketms.domain.entity.Person;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", nullable = false, length = 80)
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "Birthdate", nullable = true)
    private Date birthdate;

    @Column(name = "Email", nullable = false, length = 60)
    @NotNull(message = "El email es obligatorio")
    private String email;

    @Column(name = "Password", nullable = false, length = 60)
    @NotNull(message = "La contraseña es obligatoria")
    private String password;

    @Column(name = "Role", nullable = false, length = 60)
    @NotNull(message = "El rol es obligatorio")
    private Roles role;

    /*Relacion con addres 1 a * */
    @OneToMany(mappedBy = "person")
    private List<Address> addresses;
}
