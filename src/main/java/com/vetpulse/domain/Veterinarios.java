package com.vetpulse.domain;

import jakarta.persistence.*;

import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table(name="MedicosVeterinarios")
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

    // Constructor por defecto
    public Veterinarios() {}

    // Constructor con parámetros
    public Veterinarios(String nombre, String especialidad, String telefono, String correoElectronico, boolean activo) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.activo = activo;
    }

    // Getters y setters
    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
