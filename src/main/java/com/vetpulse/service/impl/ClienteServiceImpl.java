/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vetpulse.service.impl;

import com.vetpulse.dao.ClienteDao;
import com.vetpulse.dao.RolDao;
import com.vetpulse.domain.Cliente;
import com.vetpulse.domain.Rol;
import com.vetpulse.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsername(String username) {
        return clienteDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsernameYPassword(String username, String password) {
        return clienteDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsernameOCorreo(String username, String correo) {
        return clienteDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeClientePorUsernameOCorreo(String username, String correo) {
        return clienteDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Cliente cliente, boolean crearRolUser) {
        cliente=clienteDao.save(cliente);
        if (crearRolUser) {  //Si se está creando el cliente, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdCliente(cliente.getIdCliente());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
