package com.vetpulse.service;


import com.vetpulse.domain.Mascota;
import java.util.List;


public interface MascotaService {
    
    public List<Mascota> getMascotas(boolean activos);
    
    // Se obtiene un Mascota, a partir del id de un mascota
    public Mascota getMascota(Mascota mascota);
    
    // Se inserta un nuevo mascota si el id del mascota esta vacío
    // Se actualiza un mascota si el id del mascota NO esta vacío
    public void save(Mascota mascota);
    
    // Se elimina el mascota que tiene el id pasado por parámetro
    public void delete(Mascota mascota);
    
}
