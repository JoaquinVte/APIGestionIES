package com.ieslavereda.APIGestionIES.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estado")
@ToString
public class Estado {

    @Id
    @Getter @Setter @Column(name = "idEstado", nullable = false)
    private Integer idEstado;

    @Getter
    @Setter
    @Column(name = "descripcion")
    private String descripcion;

}
