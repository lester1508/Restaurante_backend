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

    public Platillo obtenerPorId(int id) {

        if(!this.platilloRepositorio.existsById(id)) {

            return null;
        }

        return this.platilloRepositorio.findById(id).get();
    }

    public String eliminarPorId(int id) {

        if(!this.platilloRepositorio.existsById(id)){
            return null;
        }

        this.platilloRepositorio.deleteById(id);

        return "Platillo eliminado";
    }

    public Platillo actualizarPorId(int id, Platillo platillo) {

        if(!this.platilloRepositorio.existsById(id)){
            return null;
        }
        
        Platillo platilloActualizar = this.platilloRepositorio.findById(id).get();

        platilloActualizar.setNombre(platillo.getNombre());
        platilloActualizar.setDescripcion(platillo.getDescripcion());
        platilloActualizar.setPrecio(platillo.getPrecio());
        platilloActualizar.setImg(platillo.getImg());

        return this.platilloRepositorio.save(platilloActualizar);
    }
    
}
