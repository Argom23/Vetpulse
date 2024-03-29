package com.vetpulse.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_cliente", insertable=false, updatable=false)
    List<Mascota> mascotas;
    
    
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