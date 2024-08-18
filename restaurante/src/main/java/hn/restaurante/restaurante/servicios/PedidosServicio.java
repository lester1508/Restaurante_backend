package hn.restaurante.restaurante.servicios;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.PedidoDomicilio;
import hn.restaurante.restaurante.repositorios.PedidoDomicilioRepositorio;

import java.util.List;

@Service
public class PedidosServicio {
    
    @Autowired
    private PedidoDomicilioRepositorio pedidoRepositorio;

    public PedidoDomicilio crearPedido(PedidoDomicilio pedido) {

        if(this.pedidoRepositorio.existsById(pedido.getIdPedidoDomicilio())){

            return null;
        }

        pedido.setFechaEntrega(new Timestamp(System.currentTimeMillis()));

        return this.pedidoRepositorio.save(pedido);
    }

    public List<PedidoDomicilio> obtenerTodos() {

        return this.pedidoRepositorio.findAll();
    }
}
