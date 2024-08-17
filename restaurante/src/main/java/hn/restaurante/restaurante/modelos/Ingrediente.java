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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "ingredientes")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idingrediente")
    private int idIngrediente;

    private String nombre;

    @Column(name="cantidad_disponible")
    private BigDecimal cantidadDisponible;

    private BigDecimal puntoreorden;

    private String unidad;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente")
    private List<PlatilloIngrediente> platilloIngredientes;

    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente")
    private List<PedidoProveedorIngrediente> pedidoProveedorIngredientes;
}

