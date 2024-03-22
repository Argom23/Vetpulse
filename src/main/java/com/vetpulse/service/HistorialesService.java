package com.vetpulse.service;

import com.vetpulse.domain.Historiales;
import java.util.List;

public interface HistorialesService {

    List<Historiales> obtenerHistoriales();

    void guardarHistorial(Historiales historial);

    void eliminarHistorial(Historiales historial);

    Historiales obtenerHistorialPorId(Long id);
}
