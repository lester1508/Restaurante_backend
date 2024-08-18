package hn.restaurante.restaurante.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hn.restaurante.restaurante.modelos.OrdenesPlatillos;
import hn.restaurante.restaurante.servicios.OrdenesPlatillosServicio;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-platillos")
public class OrdenesPlatillosControlador {

    @Autowired
    private OrdenesPlatillosServicio ordenesPlatillosServicio;

    @PostMapping("/crear")
    public OrdenesPlatillos asociarPlatilloAOrden(@RequestParam int idOrden, @RequestParam int idPlatillo, @RequestParam int cantidad) {
        return ordenesPlatillosServicio.asociarPlatilloAOrden(idOrden, idPlatillo, cantidad);
    }

    @GetMapping("/obtener/todas")
    public List<OrdenesPlatillos> obtenerLista() {
        return ordenesPlatillosServicio.obtenerLista();
    }

    @GetMapping("/obtener")
    public OrdenesPlatillos obtenerPorId(@RequestParam int idOrden, @RequestParam int idPlatillo) {
        return ordenesPlatillosServicio.obtenerPorId(idOrden, idPlatillo);
    }

    
}
