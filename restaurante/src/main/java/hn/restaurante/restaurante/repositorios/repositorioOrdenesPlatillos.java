package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.OrdenesPlatillos;
import hn.restaurante.restaurante.modelos.OrdenesPlatillosId;

public interface repositorioOrdenesPlatillos extends JpaRepository<OrdenesPlatillos, OrdenesPlatillosId> {
}

