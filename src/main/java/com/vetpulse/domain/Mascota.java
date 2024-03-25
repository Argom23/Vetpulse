package com.vetpulse.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="mascotas")
public class Mascota implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private boolean activo;
    private String rutaImagen;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    Cliente cliente;
    
    
    @OneToMany
    @JoinColumn(name="id_cliente", insertable=false, updatable=false)
    List<Visitas> visitas;

    public Mascota() {
    }

    public Mascota(String nombre, String especie, String raza, int edad, boolean activo, String rutaImagen, Cliente cliente) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
        this.cliente = cliente;
    }

}