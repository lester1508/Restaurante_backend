package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.TipoPlatillo;

public interface TipoPlatilloRepositorio extends JpaRepository<TipoPlatillo, Integer> {
}
