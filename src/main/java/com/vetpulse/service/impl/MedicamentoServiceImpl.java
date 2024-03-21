/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetpulse.service.impl;

import com.vetpulse.dao.MedicamentoDao;
import com.vetpulse.domain.Medicamento;
import com.vetpulse.service.MedicamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
    @Autowired
    private MedicamentoDao medicamentoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Medicamento> getMedicamentos(boolean activos) {
        List<Medicamento> lista = medicamentoDao.findAll();
        
        if(activos == true){
            // Remover los elementos inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Medicamento getMedicamento(Medicamento medicamento) {
        return medicamentoDao.findById(medicamento.getIdMedicamento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Medicamento medicamento) {
        medicamentoDao.save(medicamento);
    }

    @Override
    @Transactional
    public void delete(Medicamento medicamento) {
        medicamentoDao.delete(medicamento);
    }
}
