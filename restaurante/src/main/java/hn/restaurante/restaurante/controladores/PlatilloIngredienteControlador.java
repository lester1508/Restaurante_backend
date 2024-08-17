package hn.restaurante.restaurante.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

import hn.restaurante.restaurante.modelos.PlatilloIngrediente;
import hn.restaurante.restaurante.servicios.PlatilloIngredienteServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/platillos/ingredientes")
public class PlatilloIngredienteControlador {

    @Autowired
    private PlatilloIngredienteServicio platilloIngredienteServicio;

    @PostMapping("/asociar")
    public PlatilloIngrediente asociarPlatilloIngrediante(int idPlatillo, int idIngrediente, Double cantidad){
        return this.platilloIngredienteServicio.asociarPlatilloIngredientes(idPlatillo, idIngrediente, BigDecimal.valueOf(cantidad));
    }

    @GetMapping("/obtener")
    public List<PlatilloIngrediente> getMethodName() {
        return platilloIngredienteServicio.obtenerLista();
    }
    
}
