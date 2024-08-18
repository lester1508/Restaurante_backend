package hn.restaurante.restaurante.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.PedidoDomicilio;
import hn.restaurante.restaurante.servicios.PedidosServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@RestController
@RequestMapping("/api/pedidos")
public class PedidosControlador {
    
    @Autowired
    private PedidosServicio pedidosServicio;

    @PostMapping("/crear")
    public PedidoDomicilio crearPedido(@RequestBody PedidoDomicilio pedido) {

        return this.pedidosServicio.crearPedido(pedido);
    }

    @GetMapping("/obtener/todos")
    public List<PedidoDomicilio> obtenerTodos() {

        return this.pedidosServicio.obtenerTodos();
    }
    
    
}
