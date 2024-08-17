package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired 
    private UsuarioRepositorio usuarioRepositorio;

    public List <Usuario> obtenerTodos(){
        return this.usuarioRepositorio.findAll();
    }


    public Usuario crearNuevUsuario(Usuario NuevoUsuario){
        if(this.usuarioRepositorio.existsById(NuevoUsuario.getIdUsuario())){
            return null;
        }

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(2);
        tipoUsuario.setDescripcion("cliente");

        NuevoUsuario.setTipoUsuario(tipoUsuario);

        return this.usuarioRepositorio.save(NuevoUsuario);
    }

    public List<Usuario> buscarPorEmailContrasena(Usuario usuario) {

        return this.usuarioRepositorio.obtenerPorEmailContrasena(usuario.getEmail(), usuario.getContrasenia());
    }
    
}
