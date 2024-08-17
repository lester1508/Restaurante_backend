package hn.restaurante.restaurante.modelos;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproveedor")
    private int idProveedor;

    private String nombre;
    
    private String telefono;

    @OneToMany(mappedBy = "proveedor")
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "proveedor")
    private List<PedidoProveedor> pedidosProveedor;
}

