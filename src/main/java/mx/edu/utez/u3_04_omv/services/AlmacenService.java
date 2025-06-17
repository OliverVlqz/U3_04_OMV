package mx.edu.utez.u3_04_omv.services;


import mx.edu.utez.u3_04_omv.dtos.AdquisicionDto;
import mx.edu.utez.u3_04_omv.dtos.AlmacenDto;
import mx.edu.utez.u3_04_omv.models.Almacen;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlmacenService {
    private final List<Almacen> almacenes = new ArrayList<>();
    private final CedeService cedeService;
    private final ClienteService clienteService;
    private Long currentId = 1L;

    public AlmacenService(CedeService cedeService, ClienteService clienteService) {
        this.cedeService = cedeService;
        this.clienteService = clienteService;
    }

    public List<Almacen> getAll() {
        return almacenes;
    }

    public Almacen save(Long cedeId, AlmacenDto dto) {
        String claveCede = cedeService.getClaveById(cedeId);
        if (claveCede == null) {
            throw new IllegalArgumentException("La cede con ese ID no existe");
        }

        Almacen almacen = new Almacen(
                currentId++,
                dto.getPrecioRenta(),
                dto.getPrecioVenta(),
                dto.getTamaño(),
                claveCede
        );

        almacenes.add(almacen);
        return almacen;
    }
    public Almacen adquirirAlmacen(Long almacenId, AdquisicionDto dto) {
        Almacen almacen = almacenes.stream()
                .filter(a -> a.getId().equals(almacenId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El almacén no existe"));

        if (!almacen.getEstatus().equals("Disponible")) {
            throw new IllegalStateException("El almacén no está disponible");
        }

        if (!clienteService.existsById(dto.getClienteId())) {
            throw new IllegalArgumentException("El cliente no existe");
        }

        almacen.setClienteId(dto.getClienteId());
        almacen.setFechaAdquisicion(LocalDate.now());
        almacen.setTipoAdquisicion(dto.getTipo());
        almacen.setEstatus(dto.getTipo().equals("Compra") ? "Vendido" : "Rentado");

        return almacen;
    }

}
