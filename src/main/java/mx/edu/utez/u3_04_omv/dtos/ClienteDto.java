package mx.edu.utez.u3_04_omv.dtos;

import lombok.Getter;

@Getter
public class ClienteDto {
    private String nombreCompleto;

    public ClienteDto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
