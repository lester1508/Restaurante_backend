package hn.restaurante.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.restaurante.servicios.TipoUsuarioServicio;
import hn.restaurante.restaurante.restaurante.modelos.*;

@RestController
@RequestMapping("api/tipousuarios")
public class TipoUsuarioControlador {

    @Autowired
    private TipoUsuarioServicio tipoUsuarioServicio;

    @GetMapping("/obtener/todos")
    public List <TipoUsuario> obtenerTodos(){
        return this.tipoUsuarioServicio.obtenerTodos();
    }

    @PostMapping("/crear/tipousuario")
        public TipoUsuario crearNuevoTipoUsuario(@RequestBody TipoUsuario NuevoTipoUsuario){
            return this.tipoUsuarioServicio.crearTipoUsuario(NuevoTipoUsuario);
        }

}
