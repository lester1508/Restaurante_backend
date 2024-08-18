package hn.restaurante.restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Ingrediente;
import hn.restaurante.restaurante.repositorios.IngredienteRepositorio;
import java.util.List;

@Service
public class IngredienteServicio {

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;

    public List<Ingrediente> obtenerTodos() {

        return this.ingredienteRepositorio.findAll();
    }

    public Ingrediente crearIngrediente(Ingrediente ingrediente) {

        return this.ingredienteRepositorio.save(ingrediente);
    }

    
}
