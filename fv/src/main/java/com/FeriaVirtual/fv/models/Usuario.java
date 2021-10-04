package com.FeriaVirtual.fv.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Getter @Setter @Column(name = "rut")
    private String rut;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "correo")
    private String correo;
    @Getter @Setter @Column(name = "telefono")
    private String telefono;
    @Getter @Setter @Column(name = "tipo")
    private String tipo;
    @Getter @Setter @Column(name = "clave")
    private String clave;



}
