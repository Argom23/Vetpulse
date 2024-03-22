package com.vetpulse.service.impl;

import com.vetpulse.dao.VeterinariosDao;
import com.vetpulse.domain.Veterinarios;
import com.vetpulse.service.VeterinariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinariosServiceImpl implements VeterinariosService {

    @Autowired
    private VeterinariosDao veterinariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Veterinarios> getVeterinarios() {
        return veterinariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinarios getVeterinarios(Long id) {
        Optional<Veterinarios> optionalVeterinarios = veterinariosDao.findById(id);
        return optionalVeterinarios.orElse(null);
    }

    @Override
    @Transactional
    public void save(Veterinarios veterinarios) {
        veterinariosDao.save(veterinarios);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        veterinariosDao.deleteById(id);
    }
}
