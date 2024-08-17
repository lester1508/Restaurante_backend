package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
}

