package hn.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Factura;
import hn.restaurante.restaurante.servicios.FacturaServicio;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/facturas")
public class FacturaControlador {

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping("/obtener/todas")
    public List<Factura> obtenerTodas() {
        return this.facturaServicio.obtenerTodas();
    }

    @PostMapping("/crear/factura")
    public Factura crearNuevaFactura(@RequestBody Factura nuevaFactura) {
        return this.facturaServicio.crearNuevaFactura(nuevaFactura);
    }

    @GetMapping("/{id}")
    public Factura obtenerPorId(@PathVariable int id) {

        return this.facturaServicio.obtenerPorId(id);
    }
    
}
