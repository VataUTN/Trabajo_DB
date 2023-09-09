package com.example.ejer03.entities;

import com.example.ejer03.utils.Estado;
import com.example.ejer03.utils.TipoEnvio;
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
public class Pedido extends EntidadBase{


    private String fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String horaEstimadaEntrega;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;
    private Double total;

    @OneToOne(fetch = FetchType.EAGER)
    private Factura factura;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedidos_id")
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

}
