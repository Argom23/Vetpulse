package com.vetpulse.controller;

import com.vetpulse.domain.Visitas;
import com.vetpulse.service.VisitasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private VisitasService visitasService;

    @GetMapping("/listado")
    public String listarVisitas(Model model) {
        var visitas = visitasService.obtenerVisitas();
        model.addAttribute("visitas", visitas);
        model.addAttribute("totalVisitas", visitas.size());
        return "/visitas/listado";
    }

    @GetMapping("/nuevo")
    public String nuevaVisita(Model model) {
        model.addAttribute("visita", new Visitas());
        return "/visitas/modifica";
    }

    @PostMapping("/guardar")
    public String guardarVisita(@ModelAttribute("visita") Visitas visita) {
        visitasService.guardarVisita(visita);
        return "redirect:/visitas/listado";
    }

    @GetMapping("/eliminar/{visitaId}")
    public String eliminarVisita(@PathVariable("visitaId") Long visitaId) {
        Visitas visita = visitasService.obtenerVisitaPorId(visitaId);
        if (visita != null) {
            visitasService.eliminarVisita(visita);
        }
        return "redirect:/visitas/listado";
    }

    @GetMapping("/modificar/{visitaId}")
    public String modificarVisita(@PathVariable("visitaId") Long visitaId, Model model) {
        Visitas visita = visitasService.obtenerVisitaPorId(visitaId);
        if (visita != null) {
            model.addAttribute("visita", visita);
            return "/visitas/modifica";
        } else {
            return "redirect:/visitas/listado";
        }
    }
}
