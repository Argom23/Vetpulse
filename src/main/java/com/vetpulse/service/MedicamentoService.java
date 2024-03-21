package com.vetpulse.service;

import com.vetpulse.domain.Medicamento;
import java.util.List;

public interface MedicamentoService {

    public List<Medicamento> getMedicamentos(boolean activos);

    // Se obtiene un Medicamento, a partir del id de un medicamento
    public Medicamento getMedicamento(Medicamento medicamento);

    // Se inserta un nuevo medicamento si el id del medicamento esta vacío
    // Se actualiza un medicamento si el id del medicamento NO esta vacío
    public void save(Medicamento medicamento);

    // Se elimina el medicamento que tiene el id pasado por parámetro
    public void delete(Medicamento medicamento);
}
