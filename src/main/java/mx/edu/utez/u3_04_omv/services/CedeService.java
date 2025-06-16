package mx.edu.utez.u3_04_omv.services;

import mx.edu.utez.u3_04_omv.models.Cede;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CedeService {
    private final List<Cede> cedes = new ArrayList<>();
    private Long currentId = 1L;

    public List<Cede> getAll() {
        return cedes;
    }

    public Cede save(Cede cede) {
        cede.setId(currentId++);
        // Generar clave después de asignar ID
        String fecha = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
        int random = (int)(Math.random() * 9000) + 1000;
        cede.setClave("C" + cede.getId() + "-" + fecha + "-" + random);
        cedes.add(cede);
        return cede;
    }
    public String getClaveById(Long id) {
        return cedes.stream()
                .filter(c -> c.getId().equals(id))
                .map(Cede::getClave)
                .findFirst()
                .orElse(null);
    }


}
