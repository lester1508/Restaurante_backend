package hn.restaurante.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.restaurante.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import hn.restaurante.restaurante.restaurante.modelos.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/obtener/todos")
    public List <Usuario> obtenerTodos(){
        return this.usuarioServicio.obtenerTodos();
    }

    @PostMapping("/crear/usuario")
        public Usuario crearUsuario(@RequestBody Usuario NuevoUsuario){
            return this.usuarioServicio.crearNuevUsuario(NuevoUsuario);
        }

}
   
    

