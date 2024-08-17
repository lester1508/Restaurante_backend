package hn.restaurante.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.restaurante.modelos.Platillo;
import hn.restaurante.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.restaurante.servicios.PlatilloServicio;
import hn.restaurante.restaurante.restaurante.servicios.UsuarioServicio;

@RestController
@RequestMapping("/api/platillos")
public class PlatilloControlador {

    @Autowired
    private PlatilloServicio platilloServicio;

    @GetMapping("/obtener/todos")
    public List <Platillo> obtenerTodos(){
        return this.platilloServicio.obtenerTodos();
    }

    @PostMapping("/crear/platillo")
        public Platillo crearNuevoPlatillo(@RequestBody Platillo NuevoPlatillo){
            return this.platilloServicio.crearNuevoPlatillo(NuevoPlatillo);
        }
}
