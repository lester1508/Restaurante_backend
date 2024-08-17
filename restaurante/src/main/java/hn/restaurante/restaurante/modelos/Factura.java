package hn.restaurante.restaurante.modelos;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "facturas")

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idfactura")
    private int idFactura;

    @OneToOne
    @JoinColumn(name = "idorden")
    private Orden orden;

    private BigDecimal isv;

    private BigDecimal total;

    @Column(name = "fecha_entrega")
    private Timestamp fechaEntrega;
}

