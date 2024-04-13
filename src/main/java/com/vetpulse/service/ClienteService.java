/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vetpulse.service;

import com.vetpulse.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    // Se obtiene un listado de Clientes en un List
    public List<Cliente> getClientes();
    
    // Se obtiene un Cliente, a partir del id de un Cliente
    public Cliente getCliente(Cliente cliente);
    
    // Se obtiene un Cliente, a partir del username de un Cliente
    public Cliente getClientePorUsername(String username);

    // Se obtiene un Cliente, a partir del username y el password de un Cliente
    public Cliente getClientePorUsernameYPassword(String username, String password);
    
    // Se obtiene un Cliente, a partir del username y el password de un Cliente
    public Cliente getClientePorUsernameOCorreo(String username, String correo);
    
    // Se valida si existe un Cliente considerando el username
    public boolean existeClientePorUsernameOCorreo(String username, String correo);
    
    // Se inserta un nuevo Cliente si el id del Cliente esta vacío
    // Se actualiza un Cliente si el id del Cliente NO esta vacío
    public void save(Cliente cliente,boolean crearRolUser);
    
    // Se elimina el Cliente que tiene el id pasado por parámetro
    public void delete(Cliente cliente);
}
