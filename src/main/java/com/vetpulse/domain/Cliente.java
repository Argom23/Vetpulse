package com.vetpulse.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente; // Hibernate Transforma el id en categoria
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String telefono, String correoElectronico, boolean activo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.activo = activo;
    }
    
    
}