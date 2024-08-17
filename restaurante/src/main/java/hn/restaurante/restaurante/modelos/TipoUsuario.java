package hn.restaurante.restaurante.modelos;

import lombok.Data;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "tipousuario")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtipousuario")
    private int idTipoUsuario;

    private String descripcion;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;
}
