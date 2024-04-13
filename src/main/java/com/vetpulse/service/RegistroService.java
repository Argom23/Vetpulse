/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vetpulse.service;

import com.vetpulse.domain.Cliente;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {

    public Model activar(Model model, String cliente, String clave);

    public Model crearCliente(Model model, Cliente cliente) throws MessagingException;
    
    public void activar(Cliente cliente, MultipartFile imagenFile);
    
    public Model recordarCliente(Model model, Cliente cliente) throws MessagingException;
}
