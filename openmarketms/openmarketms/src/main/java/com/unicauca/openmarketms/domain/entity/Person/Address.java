package com.unicauca.openmarketms.domain.entity.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "address_latitude", nullable = false, length = 80)
    @NotNull(message = "La latitud es obligatoria")
    private Long latitude;
    @NotNull(message = "La longitud es obligatoria")
    @Column(name = "address_longitude", nullable = false, length = 80)
    private Long longitude;

    /*Relacion con persona * a 1 */
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
