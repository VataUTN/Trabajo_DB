package com.example.tpdb.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Rubro extends ClaseBase{
    private String denominacion;

    @OneToMany(mappedBy = "rubro", fetch = FetchType.EAGER)
    private List<Producto> productos;
}
