package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.Mesa;

public interface MesaRepositorio extends JpaRepository<Mesa, Integer> {
}
