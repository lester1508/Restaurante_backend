package hn.restaurante.restaurante.modelos;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "platillo_ingredientes")
@IdClass(PlatilloIngredienteId.class)
public class PlatilloIngrediente {
    @Id
    @ManyToOne
    @JoinColumn(name = "idingrediente")
    private Ingrediente ingrediente;

    @Id
    @ManyToOne
    @JoinColumn(name = "idplatillo")
    private Platillo platillo;

    @Column(name="cantidad_ingrediente")
    private BigDecimal cantidadIngrediente;
}




