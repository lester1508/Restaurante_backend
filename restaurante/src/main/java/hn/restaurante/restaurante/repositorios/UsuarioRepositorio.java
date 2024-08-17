package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.restaurante.restaurante.modelos.Usuario;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query(value="SELECT * FROM usuarios WHERE email = :email AND contrasenia = :contrasena", nativeQuery = true)
    public List<Usuario> obtenerPorEmailContrasena(@Param("email") String email, @Param("contrasena") String contrasena);
}

