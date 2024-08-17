package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.TipoPlatillo;
import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.repositorios.repositorioTipoPlatillo;
import hn.restaurante.restaurante.repositorios.repositorioTipoUsuario;

@Service
public class TipoPlatilloServicio {

    @Autowired
    private repositorioTipoPlatillo TipoPlatilloRepositorio;

     public List <TipoPlatillo> obtenerTodos(){
        return this.TipoPlatilloRepositorio.findAll();
    }

    public TipoPlatillo crearTipoPlatillo(TipoPlatillo NuevoTipoPlatillo){
        if(this.TipoPlatilloRepositorio.existsById(NuevoTipoPlatillo.getIdTipoPlatillo())){
            return null;
        }
        return this.TipoPlatilloRepositorio.save(NuevoTipoPlatillo);
    }
    
}
