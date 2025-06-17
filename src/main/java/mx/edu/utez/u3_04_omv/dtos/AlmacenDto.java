package mx.edu.utez.u3_04_omv.dtos;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AlmacenDto {
    @DecimalMin(value = "0.01", message = "El precio de renta debe ser mayor que 0")
    private double precioRenta;

    @DecimalMin(value = "0.01", message = "El precio de venta debe ser mayor que 0")
    private double precioVenta;

    @Pattern(regexp = "^(G|M|P)$", message = "El tamaño debe ser G, M o P")
    private String tamaño;
}
