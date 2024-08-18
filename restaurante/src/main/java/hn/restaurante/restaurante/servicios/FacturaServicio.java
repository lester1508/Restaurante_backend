package hn.restaurante.restaurante.servicios;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Factura;
import hn.restaurante.restaurante.repositorios.FacturaRepositorio;

@Service
public class FacturaServicio {

    @Autowired 
    private FacturaRepositorio facturaRepositorio;

    // Obtiene todas las facturas
    public List<Factura> obtenerTodas() {
        return this.facturaRepositorio.findAll();
    }

    // Crea una nueva factura
    public Factura crearNuevaFactura(Factura nuevaFactura) {

        nuevaFactura.setFechaEntrega(new Timestamp(System.currentTimeMillis()));

        return this.facturaRepositorio.save(nuevaFactura);
    }
}
