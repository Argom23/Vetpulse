/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetpulse.service.impl;

import com.vetpulse.dao.ClienteDao;
import com.vetpulse.domain.Cliente;
import com.vetpulse.domain.Rol;
import com.vetpulse.service.ClienteDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class ClienteDetailsServiceImpl implements ClienteDetailsService, UserDetailsService {
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Busca el cliente por el username en la tabla
        Cliente cliente = clienteDao.findByUsername(username);
        //Si no existe el cliente lanza una excepción
        if (cliente == null) {
            throw new UsernameNotFoundException(username);
        }
        session.removeAttribute("clienteImagen");
        session.setAttribute("clienteImagen", cliente.getRutaImagen());
        //Si está acá es porque existe el cliente... sacamos los roles que tiene
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : cliente.getRoles()) {   //Se sacan los roles
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se devuelve User (clase de userDetails)
        return new User(cliente.getUsername(), cliente.getPassword(), roles);
    }
}