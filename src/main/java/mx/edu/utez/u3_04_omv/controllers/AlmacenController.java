package mx.edu.utez.u3_04_omv.controllers;
import jakarta.validation.Valid;
import mx.edu.utez.u3_04_omv.dtos.AdquisicionDto;
import mx.edu.utez.u3_04_omv.dtos.AlmacenDto;
import mx.edu.utez.u3_04_omv.models.Almacen;
import mx.edu.utez.u3_04_omv.services.AlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {

    private final AlmacenService service;

    public AlmacenController(AlmacenService service) {
        this.service = service;
    }

    @GetMapping
    public List<Almacen> getAll() {
        return service.getAll();
    }

    @PostMapping("/{idCede}")
    public Almacen save(@PathVariable Long idCede, @Valid @RequestBody AlmacenDto dto) {
        return service.save(idCede, dto);
    }
    @PatchMapping("/adquirir/{almacenId}")
    public Almacen adquirir(@PathVariable Long almacenId, @Valid @RequestBody AdquisicionDto dto) {
        return service.adquirirAlmacen(almacenId, dto);
    }

}
