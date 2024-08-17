package hn.restaurante.restaurante.restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.restaurante.repositorios.MesaRepositorio;
import hn.restaurante.restaurante.restaurante.modelos.*;
import java.util.List;

@Service
public class MesaServicio {

    @Autowired 
    private MesaRepositorio mesaRepositorio;

    public List <Mesa> obtenerTodos(){
        return this.mesaRepositorio.findAll();
    }

    public Mesa crearMesa(Mesa nuevaMesa){
        if(this.mesaRepositorio.existsById(nuevaMesa.getCodigoMesa())){
            return null;
        }
        return this.mesaRepositorio.save(nuevaMesa);
    }

    
}
