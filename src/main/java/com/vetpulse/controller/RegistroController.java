/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetpulse.controller;

import com.vetpulse.domain.Cliente;
import com.vetpulse.service.RegistroService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Cliente cliente) {
        return "/registro/nuevo";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Cliente cliente) {
        return "/registro/recordar";
    }

    @PostMapping("/crearCliente")
    public String crearCliente(Model model, Cliente cliente) 
            throws MessagingException {
        model = registroService.crearCliente(model, cliente);
        return "/registro/salida";
    }

    @GetMapping("/activacion/{cliente}/{id}")
    public String activar(
            Model model, 
            @PathVariable(value = "cliente") String cliente, 
            @PathVariable(value = "id") String id) {
        model = registroService.activar(model, cliente, id);
        if (model.containsAttribute("cliente")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(
            Cliente cliente, 
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        registroService.activar(cliente);
        return "redirect:/";
    }

    @PostMapping("/recordarCliente")
    public String recordarCliente(Model model, Cliente cliente) 
            throws MessagingException {
        model = registroService.recordarCliente(model, cliente);
        return "/registro/salida";
    }
}
