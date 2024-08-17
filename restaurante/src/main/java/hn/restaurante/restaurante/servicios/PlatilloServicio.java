package hn.restaurante.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.restaurante.modelos.Platillo;
import hn.restaurante.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.restaurante.repositorios.repositorioPlatillo;

@Service
public class PlatilloServicio {

    @Autowired 
    private repositorioPlatillo PlatilloRepositorio;

    //obtiene todos los platillos
     public List <Platillo> obtenerTodos(){
        return this.PlatilloRepositorio.findAll();
    }

    //crea un nuevo platillo
    public Platillo crearNuevoPlatillo(Platillo nuevoPlatillo){
        if(this.PlatilloRepositorio.existsById(nuevoPlatillo.getIdPlatillo())){
            return null;
        }
        return this.PlatilloRepositorio.save(nuevoPlatillo);
    }
    
}
