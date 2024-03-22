package com.vetpulse.controller;

import com.vetpulse.domain.Historiales;
import com.vetpulse.service.HistorialesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/historiales")
public class HistorialesController {

    @Autowired
    private HistorialesService historialesService;

    @GetMapping("/listado")
    public String listarHistoriales(Model model) {
        var historiales = historialesService.obtenerHistoriales();
        model.addAttribute("historiales", historiales);
        model.addAttribute("totalHistoriales", historiales.size());
        return "/historiales/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoHistorial(Model model) {
        model.addAttribute("historial", new Historiales());
        return "/historiales/modifica";
    }

    @PostMapping("/guardar")
    public String guardarHistorial(@ModelAttribute("historial") Historiales historial) {
        historialesService.guardarHistorial(historial);
        return "redirect:/historiales/listado";
    }

    @GetMapping("/eliminar/{historialId}")
    public String eliminarHistorial(@PathVariable("historialId") Long historialId) {
        Historiales historial = historialesService.obtenerHistorialPorId(historialId);
        if (historial != null) {
            historialesService.eliminarHistorial(historial);
        }
        return "redirect:/historiales/listado";
    }

    @GetMapping("/modificar/{historialId}")
    public String modificarHistorial(@PathVariable("historialId") Long historialId, Model model) {
        Historiales historial = historialesService.obtenerHistorialPorId(historialId);
        if (historial != null) {
            model.addAttribute("historial", historial);
            return "/historiales/modifica";
        } else {
            return "redirect:/historiales/listado";
        }
    }
}
