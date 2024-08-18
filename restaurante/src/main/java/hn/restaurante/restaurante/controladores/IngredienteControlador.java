package hn.restaurante.restaurante.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Ingrediente;
import hn.restaurante.restaurante.servicios.IngredienteServicio;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/ingredientes")
public class IngredienteControlador {

    @Autowired
    private IngredienteServicio ingredienteServicio;
    
    @GetMapping("/obtener/todos")
    public List<Ingrediente> obtenerTodos() {

        return this.ingredienteServicio.obtenerTodos();
    }

    @PostMapping("/crear/ingrediente")
    public Ingrediente crearIngrediente(@RequestBody Ingrediente ingrediente) {

        return this.ingredienteServicio.crearIngrediente(ingrediente);
    }
    
}
