package mx.edu.utez.u3_04_omv.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdquisicionDto {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    @Pattern(regexp = "^(Compra|Renta)$", message = "El tipo debe ser 'Compra' o 'Renta'")
    private String tipo;
}