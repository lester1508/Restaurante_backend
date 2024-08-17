package hn.restaurante.restaurante.modelos;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidodomicilio")
public class PedidoDomicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpedidodomicilio")
    private int idPedidoDomicilio;

    @ManyToOne
    @JoinColumn(name = "idorden")
    private Orden orden;

    private String direccion;
    
    private String status;

    @Column(name="fecha_entrega")
    private Timestamp fechaEntrega;
}

