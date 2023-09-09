package com.example.ejer03.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends EntidadBase{

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos = new ArrayList<>();

}
