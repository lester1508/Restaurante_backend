package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.Proveedor;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
}

