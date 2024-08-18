package hn.restaurante.restaurante.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Ingrediente;
import hn.restaurante.restaurante.modelos.OrdenesPlatillos;
import hn.restaurante.restaurante.modelos.OrdenesPlatillosId;
import hn.restaurante.restaurante.modelos.PlatilloIngrediente;
import hn.restaurante.restaurante.repositorios.IngredienteRepositorio;
import hn.restaurante.restaurante.repositorios.OrdenesPlatillosRepositorio;
import hn.restaurante.restaurante.repositorios.OrdenRepositorio;
import hn.restaurante.restaurante.repositorios.PlatilloIngredienteRepositorio;
import hn.restaurante.restaurante.repositorios.PlatilloRepositorio;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdenesPlatillosServicio {

    @Autowired
    private OrdenesPlatillosRepositorio ordenesPlatillosRepositorio;

    @Autowired
    private OrdenRepositorio ordenRepositorio;

    @Autowired
    private PlatilloRepositorio platilloRepositorio;

    @Autowired
    private PlatilloIngredienteRepositorio platilloIngredienteRepositorio;

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;

    public OrdenesPlatillos asociarPlatilloAOrden(int idOrden, int idPlatillo, int cantidad) {
        if (ordenRepositorio.existsById(idOrden) && platilloRepositorio.existsById(idPlatillo)) {
            OrdenesPlatillosId ordenesPlatillosId = new OrdenesPlatillosId();
            ordenesPlatillosId.setOrden(idOrden);
            ordenesPlatillosId.setPlatillo(idPlatillo);

            if (!ordenesPlatillosRepositorio.existsById(ordenesPlatillosId)) {
                OrdenesPlatillos ordenesPlatillos = new OrdenesPlatillos();
                ordenesPlatillos.setOrden(ordenRepositorio.findById(idOrden).get());
                ordenesPlatillos.setPlatillo(platilloRepositorio.findById(idPlatillo).get());
                ordenesPlatillos.setCantidad(cantidad);

                // Verificar y actualizar la cantidad de ingredientes disponibles
                List<PlatilloIngrediente> platilloIngredientes = platilloIngredienteRepositorio.findByPlatillo(idPlatillo);
                for (PlatilloIngrediente platilloIngrediente : platilloIngredientes) {
                    BigDecimal cantidadRequerida = platilloIngrediente.getCantidadIngrediente().multiply(BigDecimal.valueOf(cantidad));
                    Ingrediente ingrediente = platilloIngrediente.getIngrediente();
                    if (ingrediente.getCantidadDisponible().compareTo(cantidadRequerida) < 0) {
                        return null; // Cantidad de ingrediente insuficiente
                    }
                }

                // Guardar la orden de platillo
                return ordenesPlatillosRepositorio.save(ordenesPlatillos);
            }
        }
        return null;
    }

    public List<OrdenesPlatillos> obtenerLista() {
        return ordenesPlatillosRepositorio.findAll();
    }

    public OrdenesPlatillos obtenerPorId(int idOrden, int idPlatillo) {
        OrdenesPlatillosId ordenesPlatillosId = new OrdenesPlatillosId();
        ordenesPlatillosId.setOrden(idOrden);
        ordenesPlatillosId.setPlatillo(idPlatillo);

        return ordenesPlatillosRepositorio.findById(ordenesPlatillosId).orElse(null);
    }

    
}
