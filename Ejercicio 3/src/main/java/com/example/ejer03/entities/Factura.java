package com.example.ejer03.entities;

import com.example.ejer03.utils.FormaPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends EntidadBase {
    private String fecha;
    private int numero;
    private Double descuento;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    private int total;

    @Override
    public String toString() {
        return "Factura{" +
                "fecha=" + fecha +
                ", numero=" + numero +
                ", descuento=" + descuento +
                ", formaPago='" + formaPago + '\'' +
                ", total=" + total +
                '}';
    }
}
