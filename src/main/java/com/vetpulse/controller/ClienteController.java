
package com.vetpulse.controller;

import com.vetpulse.domain.Cliente;
import com.vetpulse.service.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes(false);
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "/clientes/listado";
    }
    
    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/clientes/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            // Procesar la carga de archivos aquí, si es necesario
        }
        clienteService.save(cliente);
        return "redirect:/clientes/listado";
    }
 
    @GetMapping("/eliminar/{clienteId}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{clienteId}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/clientes/modifica";
    }
}
