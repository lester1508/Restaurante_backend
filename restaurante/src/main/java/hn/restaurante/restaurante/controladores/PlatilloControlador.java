package hn.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Platillo;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.servicios.PlatilloServicio;
import hn.restaurante.restaurante.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



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

    @GetMapping("/{id}")
    public Platillo obtenerPorId(@PathVariable int id) {

        return this.platilloServicio.obtenerPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable int id) {

        return this.platilloServicio.eliminarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Platillo putMethodName(@PathVariable int id, @RequestBody Platillo platillo) {

        return this.platilloServicio.actualizarPorId(id, platillo);
    }
    
}
