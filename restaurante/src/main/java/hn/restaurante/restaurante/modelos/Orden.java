package hn.restaurante.restaurante.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
import lombok.Data;

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

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<OrdenesPlatillos> ordenesPlatillos;

    @JsonIgnore
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<PedidoDomicilio> pedidosDomicilio;

    @JsonIgnore
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<Reservacion> reservaciones;

    @JsonIgnore
    @OneToOne(mappedBy = "orden", cascade = CascadeType.ALL)
    private Factura factura;
}

