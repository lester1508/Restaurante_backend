package hn.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.PedidoProveedor;
import hn.restaurante.restaurante.servicios.PedidoProveedorServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/pedido/proveedor")
public class PedidoProveedorControlador {

    @Autowired
    private PedidoProveedorServicio pedidoProveedorServicio;

    @PostMapping("/crear")
    public PedidoProveedor crearPedidoProveedor(@RequestBody PedidoProveedor pedidoProveedor) {
        
        return this.pedidoProveedorServicio.crearPedidoProveedor(pedidoProveedor);
    }
    
    @GetMapping("/obtener/por/proveedor")
    public List<PedidoProveedor> obtenerPedidosProveedor(@RequestParam int idProveedor) {
        //TODO: process POST request
        
        return this.pedidoProveedorServicio.obtenerPedidosProveedor(idProveedor);
    }
    
}
