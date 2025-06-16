package mx.edu.utez.u3_04_omv.controllers;

import jakarta.validation.Valid;
import mx.edu.utez.u3_04_omv.dtos.ClienteDto;
import mx.edu.utez.u3_04_omv.models.Cliente;
import mx.edu.utez.u3_04_omv.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClienteDto> getAll() {
        return service.getAll().stream()
                .map(cliente -> new ClienteDto(cliente.getNombreCompleto()))
                .toList();
    }
    @PostMapping
    public Cliente save(@Valid @RequestBody Cliente cliente) {
        return service.save(cliente);
    }
}
