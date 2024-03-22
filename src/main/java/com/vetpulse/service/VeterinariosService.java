package com.vetpulse.service;

import com.vetpulse.domain.Veterinarios;
import java.util.List;

public interface VeterinariosService {

    List<Veterinarios> getVeterinarios();

    Veterinarios getVeterinarios(Long id);

    void save(Veterinarios veterinarios);

    void delete(Long id);
}
