package com.vetpulse.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="HistorialesMedicos")
public class Historiales implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long idHistorial;
    
    @Column(name = "id_mascota")
    private Long idMascota;
    
    private String diagnostico;
    private String tratamiento;
    
    @Column(name = "fecha_historial")
    private String fechaHistorial;
    
    private boolean activo;

    public Historiales() {
    }
    
    public Historiales(Long idMascota, String diagnostico, String tratamiento, String fechaHistorial, boolean activo) {
        this.idMascota = idMascota;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fechaHistorial = fechaHistorial;
        this.activo = activo;
    }
}
