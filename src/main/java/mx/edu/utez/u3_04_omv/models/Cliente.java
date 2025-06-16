package mx.edu.utez.u3_04_omv.models;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private Long id;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;

    @Pattern(regexp = "^\\d{10}$", message = "El número debe tener 10 dígitos")
    private String telefono;

    @Email(message = "El correo electrónico no es válido")
    private String correo;

    public Cliente(Long id, String nombreCompleto, String telefono, String correo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
    }
}
