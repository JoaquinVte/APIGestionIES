package com.ieslavereda.APIGestionIES.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ubicaciones")
@ToString
public class Ubicacion {

    @Id
    @Getter
    @Setter
    @Column(name = "idUbicaciones", nullable = false)
    private Integer idUbicaciones;

    @Getter
    @Setter
    @Column(name = "descripcion")
    private String descripcion;



}
