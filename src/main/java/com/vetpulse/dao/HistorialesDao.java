package com.vetpulse.dao;

import com.vetpulse.domain.Historiales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialesDao extends JpaRepository<Historiales, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario
}
