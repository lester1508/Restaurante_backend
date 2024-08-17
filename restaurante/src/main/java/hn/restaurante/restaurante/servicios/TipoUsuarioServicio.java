package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.repositorios.repositorioTipoUsuario;

@Service
public class TipoUsuarioServicio {
    
    @Autowired
    private repositorioTipoUsuario TipoUsuarioRepositorio;

     public List <TipoUsuario> obtenerTodos(){
        return this.TipoUsuarioRepositorio.findAll();
    }


    public TipoUsuario crearTipoUsuario(TipoUsuario NuevoTipoUsuario){
        if(this.TipoUsuarioRepositorio.existsById(NuevoTipoUsuario.getIdTipoUsuario())){
            return null;
        }
        return this.TipoUsuarioRepositorio.save(NuevoTipoUsuario);
    }
    
}
