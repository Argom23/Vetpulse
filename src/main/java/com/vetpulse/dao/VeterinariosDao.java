package com.vetpulse.dao;

import com.vetpulse.domain.Veterinarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinariosDao extends JpaRepository<Veterinarios, Long>{
    
}
