package hn.restaurante.restaurante.modelos;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidoproveedor_ingredientes")
@IdClass(PedidoProveedorIngredienteId.class)

public class PedidoProveedorIngrediente {
    @Id
    @ManyToOne
    @JoinColumn(name = "idpedidoproveedor")
    private PedidoProveedor pedidoProveedor;

    @Id
    @ManyToOne
    @JoinColumn(name = "idingrediente")
    private Ingrediente ingrediente;

    @Column(name="cantidadcomprada")
    private BigDecimal cantidadComprada;
}

