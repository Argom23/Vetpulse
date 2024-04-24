package com.vetpulse.service.impl;

import com.vetpulse.domain.Cliente;
import com.vetpulse.service.ClienteService;
import com.vetpulse.service.CorreoService;
import com.vetpulse.service.RegistroService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @Override
    public Model activar(Model model, String username, String clave) {
        Cliente cliente = 
                clienteService.getClientePorUsernameYPassword(username, 
                        clave);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
        } else {
            model.addAttribute(
                    "titulo", 
                    messageSource.getMessage(
                            "registro.activar", 
                            null,  Locale.getDefault()));
            model.addAttribute(
                    "mensaje", 
                    messageSource.getMessage(
                            "registro.activar.error", 
                            null, Locale.getDefault()));
        }
        return model;
    }

    @Override
    public void activar(Cliente cliente) {
        var codigo = new BCryptPasswordEncoder();
        cliente.setPassword(codigo.encode(cliente.getPassword()));
        clienteService.save(cliente, true);
    }

    @Override
    public Model crearCliente(Model model, Cliente cliente) 
            throws MessagingException {
        String mensaje;
        if (!clienteService.
                existeClientePorUsernameOCorreo(
                        cliente.getUsername(), 
                        cliente.getCorreo())) {
            String clave = demeClave();
            cliente.setPassword(clave);
            cliente.setActivo(false);
            clienteService.save(cliente, true);
            enviaCorreoActivar(cliente, clave);
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.activacion.ok", 
                            null, 
                            Locale.getDefault()),
                    cliente.getCorreo());
        } else {
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.cliente.o.correo", 
                            null, 
                            Locale.getDefault()),
                    cliente.getUsername(), cliente.getCorreo());
        }
        model.addAttribute(
                "titulo", 
                messageSource.getMessage(
                        "registro.activar", 
                        null, 
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje", 
                mensaje);
        return model;
    }

    @Override
    public Model recordarCliente(Model model, Cliente cliente) 
            throws MessagingException {
        String mensaje;
        Cliente cliente2 = clienteService.getClientePorUsernameOCorreo(
                cliente.getUsername(), 
                cliente.getCorreo());
        if (cliente2 != null) {
            String clave = demeClave();
            cliente2.setPassword(clave);
            cliente2.setActivo(false);
            clienteService.save(cliente2, false);
            enviaCorreoRecordar(cliente2, clave);
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.recordar.ok", 
                            null, 
                            Locale.getDefault()),
                    cliente.getCorreo());
        } else {
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.cliente.o.correo", 
                            null, 
                            Locale.getDefault()),
                    cliente.getUsername(), cliente.getCorreo());
        }
        model.addAttribute(
                "titulo", 
                messageSource.getMessage(
                        "registro.activar", 
                        null, 
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje", 
                mensaje);
        return model;
    }

    private String demeClave() {
        String tira = "ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijklmnopqrstuvwxyz0123456789_*+-";
        String clave = "";
        for (int i = 0; i < 40; i++) {
            clave += tira.charAt((int) (Math.random() * tira.length()));
        }
        return clave;
    }

    //Ojo cómo le lee una informacion del application.properties
    @Value("${servidor.http}")
    private String servidor;

    private void enviaCorreoActivar(Cliente cliente, String clave) throws MessagingException {
        String mensaje = messageSource.getMessage(
                "registro.correo.activar", 
                null, Locale.getDefault());
        mensaje = String.format(
                mensaje, cliente.getNombre(), 
                cliente.getApellido(), servidor, 
                cliente.getUsername(), clave);
        String asunto = messageSource.getMessage(
                "registro.mensaje.activacion", 
                null, Locale.getDefault());
        correoService.enviarCorreoHtml(cliente.getCorreo(), asunto, mensaje);
    }

    private void enviaCorreoRecordar(Cliente cliente, String clave) throws MessagingException {
        String mensaje = messageSource.getMessage(""
                + "registro.correo.recordar", 
                null, 
                Locale.getDefault());
        mensaje = String.format(
                mensaje, cliente.getNombre(), 
                cliente.getApellido(), servidor, 
                cliente.getUsername(), clave);
        String asunto = messageSource.getMessage(
                "registro.mensaje.recordar", 
                null, Locale.getDefault());
        correoService.enviarCorreoHtml(
                cliente.getCorreo(), 
                asunto, mensaje);
    }
}