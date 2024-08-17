package hn.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.servicios.UsuarioServicio;



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

    @GetMapping("/buscar")
    public List<Usuario> buscarUsuarioE(@RequestBody Usuario usuario) {

        return this.usuarioServicio.buscarPorEmailContrasena(usuario);
    }
}
   
    

