package com.example.tpdb.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pedido extends ClaseBase {

    private String fecha;
    private String estado;
    private String horaEstimadaDeEntrega;
    private String tipoEnvio;
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne(mappedBy = "pedido", fetch = FetchType.EAGER)
    private Factura factura;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<DetallePedido> detallesPedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;



}