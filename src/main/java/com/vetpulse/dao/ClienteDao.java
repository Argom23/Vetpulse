
package com.vetpulse.dao;

import com.vetpulse.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long>{
    List<Cliente> findByNombre(String nombre);
    
    Cliente findByUsername(String username);
    
    Cliente findByUsernameAndPassword(String username, String Password);

    Cliente findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
