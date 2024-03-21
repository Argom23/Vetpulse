/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetpulse.service.impl;

import com.vetpulse.dao.MascotaDao;
import com.vetpulse.domain.Mascota;
import com.vetpulse.service.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    private MascotaDao mascotaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Mascota> getMascotas(boolean activos) {
        List<Mascota> lista = mascotaDao.findAll();
        
        if(activos == true){
            // Remover los elementos inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota getMascota(Mascota mascota) {
        return mascotaDao.findById(mascota.getIdMascota()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Mascota mascota) {
        mascotaDao.save(mascota);
    }

    @Override
    @Transactional
    public void delete(Mascota mascota) {
        mascotaDao.delete(mascota);
    }

}
