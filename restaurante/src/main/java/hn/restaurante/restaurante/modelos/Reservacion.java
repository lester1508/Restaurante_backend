package hn.restaurante.restaurante.modelos;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name="fechainicio")
    private Timestamp fechaInicio;

    @Column(name="fechafinal")
    private Timestamp fechaFinal;

    @ManyToOne
    @JoinColumn(name="codigo_mesa", referencedColumnName = "codigo_mesa")
    private Mesa mesa;
    
    @ManyToOne
    @JoinColumn(name = "idorden")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;
}
