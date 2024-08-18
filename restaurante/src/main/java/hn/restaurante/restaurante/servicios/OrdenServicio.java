package hn.restaurante.restaurante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Orden;
import hn.restaurante.restaurante.repositorios.OrdenRepositorio;

@Service
public class OrdenServicio {

    @Autowired 
    private OrdenRepositorio ordenRepositorio;

    // Obtiene todas las órdenes
    public List<Orden> obtenerTodas() {
        return this.ordenRepositorio.findAll();
    }

    // Crea una nueva orden
    public Orden crearNuevaOrden(Orden nuevaOrden) {
        if (this.ordenRepositorio.existsById(nuevaOrden.getIdOrden())) {
            return null;
        }
        return this.ordenRepositorio.save(nuevaOrden);
    }
}
