package mx.edu.utez.u3_04_omv.models;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Almacen {
    private Long id;
    private String clave;
    private LocalDate fechaRegistro;

    @DecimalMin(value = "0.01", message = "El precio de renta debe ser mayor que 0")
    private double precioRenta;

    @DecimalMin(value = "0.01", message = "El precio de venta debe ser mayor que 0")
    private double precioVenta;

    @Pattern(regexp = "^(G|M|P)$", message = "El tamaño debe ser G, M o P")
    private String tamaño;

    @NotBlank(message = "La clave de la cede no puede estar vacía")
    private String claveCede;

    public Almacen(Long id, double precioRenta, double precioVenta, String tamaño, String claveCede) {
        this.id = id;
        this.precioRenta = precioRenta;
        this.precioVenta = precioVenta;
        this.tamaño = tamaño;
        this.fechaRegistro = LocalDate.now();
        this.claveCede = claveCede;
        this.clave = generarClave();
    }

    private String generarClave() {
        return claveCede + "-A" + id;
    }
}
