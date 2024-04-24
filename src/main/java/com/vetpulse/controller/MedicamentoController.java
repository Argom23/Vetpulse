/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.vetpulse.controller;

import com.vetpulse.domain.Medicamento;
import com.vetpulse.service.MedicamentoService;
import com.vetpulse.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/medicamentos")
public class MedicamentoController {
    
    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var medicamentos = medicamentoService.getMedicamentos(false);
        model.addAttribute("medicamentos", medicamentos);
        model.addAttribute("totalMedicamentos", medicamentos.size());
        return "/medicamentos/listado";
    }
    
    @GetMapping("/nuevo")
    public String medicamentoNuevo(Medicamento medicamento) {
        return "/medicamentos/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String medicamentoGuardar(Medicamento medicamento,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            medicamentoService.save(medicamento);
            medicamento.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "medicamento", 
                            medicamento.getIdMedicamento()));
        }
        medicamentoService.save(medicamento);
        return "redirect:/medicamento/listado";
    }
 
    @GetMapping("/eliminar/{idMedicamento}")
    public String medicamentoEliminar(Medicamento medicamento) {
        medicamentoService.delete(medicamento);
        return "redirect:/medicamentos/listado";
    }

    @GetMapping("/modificar/{idMedicamento}")
    public String medicamentoModificar(Medicamento medicamento, Model model) {
        medicamento = medicamentoService.getMedicamento(medicamento);
        model.addAttribute("medicamento", medicamento);
        return "/medicamentos/modifica";
    }
    
}
