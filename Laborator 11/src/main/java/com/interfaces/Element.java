package com.interfaces;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NoArgsConstructor(force = true)
public abstract class Element implements Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
