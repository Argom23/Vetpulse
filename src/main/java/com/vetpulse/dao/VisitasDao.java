package com.vetpulse.dao;

import com.vetpulse.domain.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitasDao extends JpaRepository<Visitas, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
