package com.unicauca.openmarketms.AppUser.domain.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Table(name = "appUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appuser implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "email", nullable = false, length = 80)
    @NotNull(message = "El email es obligatorio")
    private String email;

    @Column(name = "password", nullable = true)
    private String password;
}
