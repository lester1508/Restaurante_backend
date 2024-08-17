package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.TipoPlatillo;
import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.repositorios.TipoPlatilloRepositorio;
import hn.restaurante.restaurante.repositorios.TipoUsuarioRepositorio;

@Service
public class TipoPlatilloServicio {

    @Autowired
    private TipoUsuarioRepositorio tipoPlatilloRepositorio;

     public List <TipoPlatillo> obtenerTodos(){
        return this.tipoPlatilloRepositorio.findAll();
    }

    public TipoPlatillo crearTipoPlatillo(TipoPlatillo NuevoTipoPlatillo){
        if(this.tipoPlatilloRepositorio.existsById(NuevoTipoPlatillo.getIdTipoPlatillo())){
            return null;
        }
        return this.tipoPlatilloRepositorio.save(NuevoTipoPlatillo);
    }
    
}
