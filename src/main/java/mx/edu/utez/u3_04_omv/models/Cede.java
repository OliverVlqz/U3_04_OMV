package mx.edu.utez.u3_04_omv.models;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cede {
    private Long id;
    private String clave;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    @NotBlank(message = "El municipio no puede estar vacío")
    private String municipio;

    public Cede(Long id, String estado, String municipio) {
        this.id = id;
        this.estado = estado;
        this.municipio = municipio;
    }


}
