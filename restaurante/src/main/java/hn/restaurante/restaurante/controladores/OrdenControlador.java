package hn.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Orden;
import hn.restaurante.restaurante.servicios.OrdenServicio;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenControlador {

    @Autowired
    private OrdenServicio ordenServicio;

    @GetMapping("/obtener/todas")
    public List<Orden> obtenerTodas() {
        return this.ordenServicio.obtenerTodas();
    }

    @PostMapping("/crear/orden")
    public Orden crearNuevaOrden(@RequestBody Orden nuevaOrden) {
        return this.ordenServicio.crearNuevaOrden(nuevaOrden);
    }
}
