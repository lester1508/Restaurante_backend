package hn.restaurante.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.restaurante.repositorios.repositorioUsuario;
import hn.restaurante.restaurante.restaurante.modelos.*;

@Service
public class UsuarioServicio {

    @Autowired 
    private repositorioUsuario UsuarioRepositorio;

    public List <Usuario> obtenerTodos(){
        return this.UsuarioRepositorio.findAll();
    }


    public Usuario crearNuevUsuario(Usuario NuevoUsuario){
        if(this.UsuarioRepositorio.existsById(NuevoUsuario.getIdUsuario())){
            return null;
        }
        return this.UsuarioRepositorio.save(NuevoUsuario);
    }
    
}
