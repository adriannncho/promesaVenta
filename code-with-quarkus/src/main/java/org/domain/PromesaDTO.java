package org.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromesaDTO {

    @NotNull(message = "El nombre del cliente no puede ser nulo o estar vacío")
    private String nombreCliente;

    @NotNull(message = "El nombre del dueño no puede ser nulo o estar vacío")
    private String nombreDuenio;

    @NotNull(message = "La fecha inicial no puede ser nula o estar vacía")
    private String fechaInicial;

    @NotNull(message = "La fecha final no puede ser nula o estar vacía")
    private String fechaFinal;

    @NotNull(message = "El valor de la venta no puede ser nulo o estar vacío")
    private String valorVenta;

    @NotNull(message = "La ubicación no puede ser nula o estar vacía")
    private String ubicacion;

    @NotNull(message = "La notaría no puede ser nula o estar vacía")
    private String notaria;

    @NotNull(message = "La dirección no puede ser nula o estar vacía")
    private String direccion;

    @NotNull(message = "El número de escritura no puede ser nulo")
    @Min(value = 1, message = "El número de escritura debe ser mayor a 0")
    private Long numeroEscritura;

    @NotNull(message = "La fecha de la escritura no puede ser nula o estar vacía")
    private String fechaEscritura;

    @NotNull(message = "El código catastral no puede ser nulo o estar vacío")
    private String codigoCatastral;

    @NotNull(message = "La matrícula inmobiliaria no puede ser nula o estar vacía")
    private String matriculaInmobiliaria;

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
    private Long precio;

    @NotNull(message = "La fecha de la notaría no puede ser nula o estar vacía")
    private String fechaNotaria;
}
