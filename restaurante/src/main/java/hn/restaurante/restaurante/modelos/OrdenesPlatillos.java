package hn.restaurante.restaurante.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ordenes_platillos")
@IdClass(OrdenesPlatillosId.class)

public class OrdenesPlatillos {
    @Id
    @ManyToOne
    @JoinColumn(name = "idorden")
    private Orden orden;

    @Id
    @ManyToOne
    @JoinColumn(name = "idplatillo")
    private Platillo platillo;

    private int cantidad;
}

