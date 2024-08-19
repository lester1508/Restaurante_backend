package hn.restaurante.restaurante.servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Ingrediente;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.modelos.PedidoProveedor;
import hn.restaurante.restaurante.modelos.PedidoProveedorIngrediente;
import hn.restaurante.restaurante.modelos.Proveedor;
import hn.restaurante.restaurante.repositorios.IngredienteRepositorio;
import hn.restaurante.restaurante.repositorios.PedidoProveedorRepositorio;
import hn.restaurante.restaurante.repositorios.ProveedorRepositorio;
import hn.restaurante.restaurante.repositorios.UsuarioRepositorio;

@Service
public class PedidoProveedorServicio {

    @Autowired
    private PedidoProveedorRepositorio pedidoProveedorRepositorio;

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;


    public PedidoProveedor crearPedidoProveedor(PedidoProveedor pedidoProveedor){

        //verifiacando que existe el usuario
        int idUsuario = pedidoProveedor.getUsuario().getIdUsuario();
            if(this.usuarioRepositorio.existsById(idUsuario)==false){
                return null;
            }
        
        //Asignando el usuario al pedido
        Usuario usuario = this.usuarioRepositorio.findById(idUsuario).get();
        pedidoProveedor.setUsuario(usuario);
        
        //verificando que existe el proveedor
        int idProveedor = pedidoProveedor.getProveedor().getIdProveedor();
        if(this.proveedorRepositorio.existsById(idProveedor)==false){
        return null;}
        
        //Asignando el proveedor al pedido
        Proveedor proveedor = this.proveedorRepositorio.findById(idProveedor).get();
        pedidoProveedor.setProveedor(proveedor);

        //verificando que la lista no este vacia para despues recorrerla
        List<PedidoProveedorIngrediente> pedidoProveedorIngredientes = pedidoProveedor.getPedidoProveedorIngredientes();
        List<PedidoProveedorIngrediente> pedidoProveedorIngredientes2 = new ArrayList<>();
        if(pedidoProveedorIngredientes!=null){
            for (PedidoProveedorIngrediente pedidoProveedorIngrediente : pedidoProveedorIngredientes) {

                ////asignando el pedido a elemeneto de la lista pedidoProveedorIngrediente
                pedidoProveedorIngrediente.setPedidoProveedor(pedidoProveedor);

                //verificar que el ingrediente existe y si se encuentra en la lista de proveedores
                int idingrediente = pedidoProveedorIngrediente.getIngrediente().getIdIngrediente();
                Ingrediente ingrediente;
                if(this.ingredienteRepositorio.existsById(idingrediente)){
                     ingrediente = this.ingredienteRepositorio.findById(idingrediente).get();
                     if(ingrediente.getProveedor().getIdProveedor()==pedidoProveedor.getProveedor().getIdProveedor()){
                        pedidoProveedorIngrediente.setIngrediente(ingrediente);
                        pedidoProveedorIngredientes2.add(pedidoProveedorIngrediente);

                        //sumar la cantidad comprada al inventario
                        BigDecimal cantidadNueva = ingrediente.getCantidadDisponible().add(pedidoProveedorIngrediente.getCantidadComprada());
                        ingrediente.setCantidadDisponible(cantidadNueva);

                        this.ingredienteRepositorio.save(ingrediente);

                        /*
                         * si fuerea una resta  seria: 
                         * cantidadNueva = ingrediente.getCantidadDisponible().subtract(pedidoProveedorIngrediente.getCantidadComprada());
                         */

                    }
                }


             
            }
            
        
            //Asignando la lista con cambios al Pedido
            pedidoProveedor.setPedidoProveedorIngredientes(pedidoProveedorIngredientes2);
        }

        return this.pedidoProveedorRepositorio.save(pedidoProveedor);
    }

    
    public List<PedidoProveedor> obtenerPedidosProveedor(int idProveedor){
        if(this.proveedorRepositorio.existsById(idProveedor)){
        Proveedor proveedor = this.proveedorRepositorio.findById(idProveedor).get();
        return this.pedidoProveedorRepositorio.findByProveedor(proveedor);
    }
        return null;
    }

    public Ingrediente crearPedido(int idIngrediente, BigDecimal cantidad) {

        if(!this.ingredienteRepositorio.existsById(idIngrediente)) {

            return null;
        }

        Ingrediente ingrediente = this.ingredienteRepositorio.findById(idIngrediente).get();
        ingrediente.setCantidadDisponible(ingrediente.getCantidadDisponible().add(cantidad));

        this.ingredienteRepositorio.save(ingrediente);

        return ingrediente;
    }

    
}
