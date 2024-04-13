package com.vetpulse.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
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
    private String apellido;
    private String direccion;
    private String telefono;
    @Column(name = "correo_electronico")
    private String correo;
    private boolean activo;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String rutaImagen;
    
    @OneToMany
    @JoinColumn(name="id_cliente", insertable=false, updatable=false)
    List<Mascota> mascotas;
    
    @OneToMany
    @JoinColumn(name = "id_cliente")
    private List<Rol> roles;
    
    
}