package hn.restaurante.restaurante.modelos;


import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "tipoplatillo")
public class TipoPlatillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtipoplatillo")
    private int idTipoPlatillo;

    @Column(name="nombre_tipo")
    private String nombreTipo;

    @Column(name="fecha_tipo")
    private Timestamp fechaTipo;

    @OneToMany(mappedBy = "tipoPlatillo")
    private List<Platillo> platillos;
}
