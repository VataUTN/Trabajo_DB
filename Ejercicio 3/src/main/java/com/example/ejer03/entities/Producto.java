package com.example.ejer03.entities;

import com.example.ejer03.utils.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends EntidadBase{
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private int stockMinimo;
    private int stockActual;
    private String unidadMedida;
    private String receta;
    private String foto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Rubro rubro;
}
