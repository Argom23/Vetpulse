package com.vetpulse.controller;

import com.vetpulse.domain.Mascota;
import com.vetpulse.service.MascotaService;
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
@RequestMapping("/mascotas")
public class MascotaController {
    
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var mascotas = mascotaService.getMascotas(false);
        model.addAttribute("mascotas", mascotas);
        model.addAttribute("totalMascotas", mascotas.size());
        return "/mascotas/listado";
    }
    
    @GetMapping("/nuevo")
    public String mascotaNuevo(Mascota mascota) {
        return "/mascotas/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String mascotaGuardar(Mascota mascota,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            mascotaService.save(mascota);
            mascota.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "mascota", 
                            mascota.getIdMascota()));
        }
        mascotaService.save(mascota);
        return "redirect:/mascota/listado";
    }
 
    @GetMapping("/eliminar/{mascotaId}")
    public String mascotaEliminar(Mascota mascota) {
        mascotaService.delete(mascota);
        return "redirect:/mascotas/listado";
    }

    @GetMapping("/modificar/{mascotaId}")
    public String mascotaModificar(Mascota mascota, Model model) {
        mascota = mascotaService.getMascota(mascota);
        model.addAttribute("mascota", mascota);
        return "/mascotas/modifica";
    }
}