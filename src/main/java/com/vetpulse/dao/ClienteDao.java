
package com.vetpulse.dao;

import com.vetpulse.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long>{
    
}
