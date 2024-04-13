package com.vetpulse.controller;

import com.vetpulse.domain.Cliente;
import com.vetpulse.service.ClienteService;
import com.vetpulse.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "/clientes/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/clientes/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        boolean nuevo = true;
        // Validar si es una creación o modificación (Si trae ID)
        if (cliente.getIdCliente() != 0) {
            nuevo = false;
            Cliente actual = clienteService.getCliente(cliente);
            cliente.setPassword(actual.getPassword());
            cliente.setUsername(actual.getUsername());
            cliente.setActivo(actual.isActivo());
            cliente.setRoles(actual.getRoles());
            if (imagenFile.isEmpty()) {
                cliente.setRutaImagen(actual.getRutaImagen());
            }
        } else {
            cliente.setPassword(new BCryptPasswordEncoder().encode(cliente.getPassword()));
            cliente.setActivo(true); // Para crearlo siempre activo
        }
        if (!imagenFile.isEmpty()) {
            clienteService.save(cliente, false);
            cliente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cliente",
                            cliente.getIdCliente()));
        }
        clienteService.save(cliente, nuevo);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/clientes/modifica";
    }
}
