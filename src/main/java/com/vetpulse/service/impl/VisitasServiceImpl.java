package com.vetpulse.service.impl;

import com.vetpulse.domain.Visitas;
import com.vetpulse.dao.VisitasDao;
import com.vetpulse.service.VisitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitasServiceImpl implements VisitasService {

    @Autowired
    private VisitasDao visitasDao;

    @Override
    public List<Visitas> obtenerVisitas() {
        return visitasDao.findAll();
    }

    @Override
    public void guardarVisita(Visitas visita) {
        visitasDao.save(visita);
    }

    @Override
    public void eliminarVisita(Visitas visita) {
        visitasDao.delete(visita);
    }

    @Override
    public Visitas obtenerVisitaPorId(Long id) {
        Optional<Visitas> optionalVisita = visitasDao.findById(id);
        return optionalVisita.orElse(null);
    }
}
