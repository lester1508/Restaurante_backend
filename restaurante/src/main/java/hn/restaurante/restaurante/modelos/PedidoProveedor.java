package hn.restaurante.restaurante.modelos;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "pedidoproveedor")
public class PedidoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpedidoproveedor")
    private int idPedidoProveedor;

    @ManyToOne
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    private BigDecimal total;

    private Timestamp fechaPedido;

    @OneToMany(mappedBy = "pedidoProveedor")
    private List<PedidoProveedorIngrediente> pedidoProveedorIngredientes;
}

