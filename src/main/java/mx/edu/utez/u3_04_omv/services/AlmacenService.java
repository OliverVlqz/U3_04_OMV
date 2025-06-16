package mx.edu.utez.u3_04_omv.services;


import mx.edu.utez.u3_04_omv.models.Almacen;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlmacenService {
    private final List<Almacen> almacenes = new ArrayList<>();
    private final CedeService cedeService;
    private Long currentId = 1L;

    public AlmacenService(CedeService cedeService) {
        this.cedeService = cedeService;
    }

    public List<Almacen> getAll() {
        return almacenes;
    }

    public Almacen save(Long cedeId, Almacen almacen) {
        String claveCede = cedeService.getClaveById(cedeId);
        if (claveCede == null) {
            throw new IllegalArgumentException("La cede con ese ID no existe");
        }

        almacen.setId(currentId++);
        almacen.setClave(claveCede + "-A" + almacen.getId());
        almacen.setFechaRegistro(java.time.LocalDate.now());
        almacen.setClaveCede(claveCede); // opcional, por referencia
        almacenes.add(almacen);
        return almacen;
    }

}
