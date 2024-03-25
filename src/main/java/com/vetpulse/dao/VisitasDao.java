package com.vetpulse.dao;

import com.vetpulse.domain.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitasDao extends JpaRepository<Visitas, Long> {
    
}
