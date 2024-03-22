package com.vetpulse.service.impl;

import com.vetpulse.domain.Historiales;
import com.vetpulse.dao.HistorialesDao;
import com.vetpulse.service.HistorialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialesServiceImpl implements HistorialesService {

    @Autowired
    private HistorialesDao historialesDao;

    @Override
    public List<Historiales> obtenerHistoriales() {
        return historialesDao.findAll();
    }

    @Override
    public void guardarHistorial(Historiales historial) {
        historialesDao.save(historial);
    }

    @Override
    public void eliminarHistorial(Historiales historial) {
        historialesDao.delete(historial);
    }

    @Override
    public Historiales obtenerHistorialPorId(Long id) {
        Optional<Historiales> optionalHistorial = historialesDao.findById(id);
        return optionalHistorial.orElse(null);
    }
}
