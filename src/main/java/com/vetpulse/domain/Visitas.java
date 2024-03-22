package com.vetpulse.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Visitas")
public class Visitas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita")
    private Long idVisita;

    @Column(name = "fecha_hora")
    private String fechaHora;

    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "razon_visita")
    private String razonVisita;

    @Column(name = "tratamiento_realizado")
    private String tratamientoRealizado;

    @Column(name = "activo")
    private boolean activo;

    public Visitas() {
    }

    public Visitas(String fechaHora, Long idMascota, String razonVisita, String tratamientoRealizado, boolean activo) {
        this.fechaHora = fechaHora;
        this.idMascota = idMascota;
        this.razonVisita = razonVisita;
        this.tratamientoRealizado = tratamientoRealizado;
        this.activo = activo;
    }

    // Getters and setters

    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public String getRazonVisita() {
        return razonVisita;
    }

    public void setRazonVisita(String razonVisita) {
        this.razonVisita = razonVisita;
    }

    public String getTratamientoRealizado() {
        return tratamientoRealizado;
    }

    public void setTratamientoRealizado(String tratamientoRealizado) {
        this.tratamientoRealizado = tratamientoRealizado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
