package com.vetpulse.controller;

import com.vetpulse.domain.Veterinarios;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.vetpulse.service.VeterinariosService;

@Controller
@Slf4j
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinariosService veterinariosService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var veterinarios = veterinariosService.getVeterinarios();
        model.addAttribute("veterinarios", veterinarios);
        model.addAttribute("totalVeterinarios", veterinarios.size());
        return "/veterinarios/listado";
    }

    @GetMapping("/nuevo")
    public String veterinarioNuevo(Model model) {
        model.addAttribute("veterinario", new Veterinarios());
        return "/veterinarios/modifica";
    }

    @PostMapping("/guardar")
    public String veterinarioGuardar(@ModelAttribute Veterinarios veterinario) {
        veterinariosService.save(veterinario);
        return "redirect:/veterinarios/listado";
    }

    @GetMapping("/eliminar/{idVeterinario}")
    public String veterinarioEliminar(@PathVariable Long idVeterinario) {
        veterinariosService.delete(idVeterinario);
        return "redirect:/veterinarios/listado";
    }

    @GetMapping("/modificar/{idVeterinario}")
    public String veterinarioModificar(@PathVariable Long idVeterinario, Model model) {
        Veterinarios veterinario = veterinariosService.getVeterinarios(idVeterinario);
        model.addAttribute("veterinario", veterinario);
        return "/veterinarios/modifica";
    }
}
