package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.repositorios.UsuarioRepositorio;
import hn.restaurante.restaurante.modelos.*;

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
        return this.usuarioRepositorio.save(NuevoUsuario);
    }
    
}
