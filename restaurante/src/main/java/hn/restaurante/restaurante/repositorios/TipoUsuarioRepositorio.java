package hn.restaurante.restaurante.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.TipoUsuario;

public interface TipoUsuarioRepositorio extends JpaRepository<TipoUsuario, Integer> {
}
