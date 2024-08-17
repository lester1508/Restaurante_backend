package hn.restaurante.restaurante.modelos;


import lombok.Data;
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
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private int idUsuario;

    private String nombre;

    private String apellido;

    private String email;

    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "idtipousuario")
    private TipoUsuario tipoUsuario;

    @Column(name="fecha_creacion")
    private Timestamp fechaCreacion;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;

    @OneToMany(mappedBy = "usuario")
    private List<PedidoProveedor> pedidosProveedor;

    @OneToMany(mappedBy = "usuario")
    private List<Reservacion> reservaciones;
}
