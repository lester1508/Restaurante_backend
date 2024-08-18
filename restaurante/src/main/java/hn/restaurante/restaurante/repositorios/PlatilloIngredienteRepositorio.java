package hn.restaurante.restaurante.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.PlatilloIngrediente;
import hn.restaurante.restaurante.modelos.PlatilloIngredienteId;

public interface PlatilloIngredienteRepositorio extends JpaRepository<PlatilloIngrediente, PlatilloIngredienteId> {

    // List<PlatilloIngrediente> findByPlatillo(int idPlatillo);
}

