package com.vetpulse.dao;

import com.vetpulse.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoDao extends JpaRepository<Medicamento, Long>{
    
}
