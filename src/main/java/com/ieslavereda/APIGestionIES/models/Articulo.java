package com.ieslavereda.APIGestionIES.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Articulo")
@ToString
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="idArticulo")
    private int idArticulo;

    @Getter @Setter @Column(name="descripcion")
    private String descripcion;

    @Getter @Setter @Column(name="ubicacion")
    private int ubicacion;

    @Getter @Setter @Column(name="estado")
    private int estado;

    @Getter @Setter @Column(name="tipoArticulo")
    private int tipoArticulo;

    @Getter @Setter @Column(name="departamento")
    private int departamento;

    @Getter @Setter @Column(name="foto")
    private byte[] foto;

    public Articulo (){};

    private Articulo(int idArticulo, String descripcion, int ubicacion, int estado, int tipoArticulo, int departamento, byte[] foto) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.tipoArticulo = tipoArticulo;
        this.departamento = departamento;
        this.foto = foto;
    }

    public static class ArticuloBuilder {

        private int idArticulo;
        private String descripcion;
        private int ubicacion;
        private int estado;
        private int tipoArticulo;
        private int departamento;
        private byte[] foto;


        public Articulo build() {
            return new Articulo(idArticulo, descripcion, ubicacion, estado,
                    tipoArticulo, departamento, foto);
        }

        public ArticuloBuilder withIdArticulo(int id) {
            this.idArticulo = id;
            return this;
        }

        public ArticuloBuilder withDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ArticuloBuilder withUbicacion(int ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }

        public ArticuloBuilder withEstado(int estado) {
            this.estado = estado;
            return this;
        }

        public ArticuloBuilder withTipoArticulo(int tipoArticulo) {
            this.tipoArticulo = tipoArticulo;
            return this;
        }

        public ArticuloBuilder withFoto(byte[] foto) {
            this.foto = foto;
            return this;
        }

        public ArticuloBuilder withDepartamento(int departamento) {
            this.departamento = departamento;
            return this;
        }
    }
}
