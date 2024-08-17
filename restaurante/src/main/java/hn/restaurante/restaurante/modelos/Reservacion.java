package hn.restaurante.restaurante.modelos;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="reservaciones")
public class Reservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idreservacion")
    private int idReservacion;

    private String status;

    @Column(name="fechainicio")
    private Timestamp fechaInicio;

    @Column(name="fechafinal")
    private Timestamp fechaFinal;
    
    @OneToOne
    @JoinColumn(name="codigo_mesa", referencedColumnName = "codigo_mesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name="idusuario", referencedColumnName = "idusuario")
    private Usuario usuario;


}
