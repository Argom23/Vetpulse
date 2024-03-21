package com.vetpulse.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Long idMedicamento;
    private String nombre;
    private String descripcion;
    private String dosificacion;
    private double precio;
    private String rutaImagen;
    private boolean activo;

    public Medicamento() {
    }
    
    public Medicamento(String nombre, String descripcion, String dosificacion, double precio, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dosificacion = dosificacion;
        this.precio = precio;
        this.activo = activo;
    }
}