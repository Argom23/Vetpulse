package com.vetpulse.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="Historialesmedicos")
public class Historiales implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long idHistorial;    
    private String diagnostico;
    private String tratamiento;
    
    @Column(name = "fecha_historial")
    private String fechaHistorial;
    
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_mascota")
    Mascota mascota;

    public Historiales() {
    }

    public Historiales(String diagnostico, String tratamiento, String fechaHistorial, boolean activo, Mascota mascota) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fechaHistorial = fechaHistorial;
        this.activo = activo;
        this.mascota = mascota;
    }
    
    
    
}
