package hn.restaurante.restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.PlatilloIngrediente;
import hn.restaurante.restaurante.repositorios.IngredienteRepositorio;
import hn.restaurante.restaurante.repositorios.PlatilloIngredienteRepositorio;
import hn.restaurante.restaurante.repositorios.PlatilloRepositorio;

import java.util.List;

import java.math.BigDecimal;

@Service
public class PlatilloIngredienteServicio {

    @Autowired
    private PlatilloRepositorio platilloRepositorio;

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;

    @Autowired
    private PlatilloIngredienteRepositorio platilloIngredienteRepositorio;
    
    public PlatilloIngrediente asociarPlatilloIngredientes(int idPlatillo, int idIngrediente, BigDecimal cantidad){

        if(this.platilloRepositorio.existsById(idPlatillo)){
            if(this.ingredienteRepositorio.existsById(idIngrediente)){

                PlatilloIngrediente platilloIngrediente = new PlatilloIngrediente();
                platilloIngrediente.setPlatillo(this.platilloRepositorio.findById(idPlatillo).get());
                platilloIngrediente.setIngrediente(this.ingredienteRepositorio.findById(idIngrediente).get());
                platilloIngrediente.setCantidadIngrediente(cantidad);

                return this.platilloIngredienteRepositorio.save(platilloIngrediente);
            }
        }else{
            return null;
        }

        return null;
    }

    public List<PlatilloIngrediente> obtenerLista(){
       return this.platilloIngredienteRepositorio.findAll();
    }
    }


