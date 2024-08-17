package hn.restaurante.restaurante.modelos;

import lombok.Data;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idorden")
    private int idOrden;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    private String status;

    @OneToMany(mappedBy = "orden")
    private List<OrdenesPlatillos> ordenesPlatillos;

    @OneToMany(mappedBy = "orden")
    private List<PedidoDomicilio> pedidosDomicilio;

    @OneToOne(mappedBy = "orden")
    private Factura factura;
}

