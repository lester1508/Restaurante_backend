package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Platillo;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.repositorios.PlatilloRepositorio;

@Service
public class PlatilloServicio {

    @Autowired 
    private PlatilloRepositorio platilloRepositorio;

    //obtiene todos los platillos
     public List <Platillo> obtenerTodos(){
        return this.platilloRepositorio.findAll();
    }

    //crea un nuevo platillo
    public Platillo crearNuevoPlatillo(Platillo nuevoPlatillo){
        if(this.platilloRepositorio.existsById(nuevoPlatillo.getIdPlatillo())){
            return null;
        }
        return this.platilloRepositorio.save(nuevoPlatillo);
    }
    
}
