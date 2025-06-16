package mx.edu.utez.u3_04_omv.controllers;

import jakarta.validation.Valid;
import mx.edu.utez.u3_04_omv.models.Cede;
import mx.edu.utez.u3_04_omv.services.CedeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cedes")
public class CedeController {

    private final CedeService service;

    public CedeController(CedeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cede> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Cede save(@Valid @RequestBody Cede cede) {
        return service.save(cede);
    }

}
