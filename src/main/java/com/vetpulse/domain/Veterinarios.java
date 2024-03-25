package com.vetpulse.domain;

import jakarta.persistence.*;

import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table(name="medicosveterinarios")
public class Veterinarios implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario")
    private Long idVeterinario;
    
    private String nombre;
    private String especialidad;
    private String telefono;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    
    private boolean activo;

    public Veterinarios() {}

    public Veterinarios(String nombre, String especialidad, String telefono, String correoElectronico, boolean activo) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.activo = activo;
    }
}
