package com.lumtec.computo.infra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "provedores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Provedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Provedor(Long id) {
        this.id = id;
    }

    public Provedor(String selectedItem) {
        this.nombre = selectedItem;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

}
