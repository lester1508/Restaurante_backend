package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.repositorios.TipoUsuarioRepositorio;

@Service
public class TipoUsuarioServicio {
    
    @Autowired
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;

     public List <TipoUsuario> obtenerTodos(){
        return this.tipoUsuarioRepositorio.findAll();
    }


    public TipoUsuario crearTipoUsuario(TipoUsuario NuevoTipoUsuario){
        if(this.tipoUsuarioRepositorio.existsById(NuevoTipoUsuario.getIdTipoUsuario())){
            return null;
        }
        return this.tipoUsuarioRepositorio.save(NuevoTipoUsuario);
    }
    
}
