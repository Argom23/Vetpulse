package com.vetpulse.dao;

import com.vetpulse.domain.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaDao extends JpaRepository<Mascota, Long>{
    
}
