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
    private double precioRenta;
    private double precioVenta;
    private String tamaño;
    private String claveCede;

    // NUEVOS CAMPOS
    private String estatus = "Disponible"; // Disponible, Rentado, Vendido
    private Long clienteId; // ID del cliente que adquirió el almacén
    private LocalDate fechaAdquisicion;
    private String tipoAdquisicion; // "Compra" o "Renta"

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