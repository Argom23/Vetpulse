/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vetpulse.service;

import com.vetpulse.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List<Cliente> getClientes(boolean activos);
    
    // Se obtiene un Cliente, a partir del id de un cliente
    public Cliente getCliente(Cliente cliente);
    
    // Se inserta un nuevo cliente si el id del cliente esta vacío
    // Se actualiza un cliente si el id del cliente NO esta vacío
    public void save(Cliente cliente);
    
    // Se elimina el cliente que tiene el id pasado por parámetro
    public void delete(Cliente cliente);
    
    public List<Cliente> buscarPorNombre(String nombre);
}
