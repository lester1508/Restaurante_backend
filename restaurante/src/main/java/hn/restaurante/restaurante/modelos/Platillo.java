package hn.restaurante.restaurante.modelos;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "platillos")
public class Platillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplatillo")
    private int idPlatillo;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "idtipoplatillo")
    private TipoPlatillo tipoPlatillo;

    @OneToMany(mappedBy = "platillo")
    private List<PlatilloIngrediente> platilloIngredientes;

    @OneToMany(mappedBy = "platillo")
    private List<OrdenesPlatillos> ordenesPlatillos;
}
