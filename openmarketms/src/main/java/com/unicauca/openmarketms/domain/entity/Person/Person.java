package com.unicauca.openmarketms.domain.entity.Person;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_name", nullable = false, length = 80)
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name = "person_birthdate", nullable = true)
    private Date birthdate;

    @Column(name = "person_email", nullable = false, length = 60)
    @NotNull(message = "El email es obligatorio")
    private String email;

    @Column(name = "person_password", nullable = false, length = 60)
    @NotNull(message = "La contraseña es obligatoria")
    private String password;

    @Column(name = "person_role", nullable = false, length = 60)
    @NotNull(message = "El rol es obligatorio")
    private Roles role;

    /*Relacion con addres 1 a * */
    @OneToMany(mappedBy = "person")
    private Set<Address> addresses;

}
