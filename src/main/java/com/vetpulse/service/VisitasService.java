package com.vetpulse.service;

import com.vetpulse.domain.Visitas;

import java.util.List;

public interface VisitasService {

    List<Visitas> obtenerVisitas();

    void guardarVisita(Visitas visita);

    void eliminarVisita(Visitas visita);

    Visitas obtenerVisitaPorId(Long id);
}
