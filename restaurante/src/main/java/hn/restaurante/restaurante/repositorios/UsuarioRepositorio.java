package hn.restaurante.restaurante.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.restaurante.restaurante.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query(value="SELECT * FROM usuarios WHERE email = :email AND contrasenia = :contrasena", nativeQuery = true)
    public List<Usuario> obtenerPorEmailContrasena(@Param("email") String email, @Param("contrasena") String contrasena);

    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE usuarios SET idTipoUsuario = 1 WHERE idUsuario = :idUsuario", nativeQuery = true)
    public void darPrivilegios(@Param("idUsuario") int idUsuario);

    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE usuarios SET idTipoUsuario = 2 WHERE idUsuario = :idUsuario", nativeQuery = true)
    public void quitarPrivilegios(@Param("idUsuario") int idUsuario);
}

