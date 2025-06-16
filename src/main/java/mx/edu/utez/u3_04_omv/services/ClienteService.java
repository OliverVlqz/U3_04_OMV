package mx.edu.utez.u3_04_omv.services;

import mx.edu.utez.u3_04_omv.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private final List<Cliente> clientes = new ArrayList<>();
    private Long currentId = 1L;

    public List<Cliente> getAll() {
        return clientes;
    }

    public Cliente save(Cliente cliente) {
        cliente.setId(currentId++);
        clientes.add(cliente);
        return cliente;
    }
}
