package com.vetpulse.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
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
    
    @Column(name = "razon_visita")
    private String razonVisita;
    
    @Column(name = "tratamiento_realizado")
    private String tratamientoRealizado;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_mascota")
    Mascota mascota;

    public Visitas() {
    }

    public Visitas(String fechaHora, String razonVisita, String tratamientoRealizado, boolean activo, Mascota mascota) {
        this.fechaHora = fechaHora;
        this.razonVisita = razonVisita;
        this.tratamientoRealizado = tratamientoRealizado;
        this.activo = activo;
        this.mascota = mascota;
    }

    
    
    
    
}
