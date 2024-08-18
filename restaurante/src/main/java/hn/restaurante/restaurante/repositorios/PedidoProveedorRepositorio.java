package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.restaurante.restaurante.modelos.PedidoProveedor;
import hn.restaurante.restaurante.modelos.Proveedor;

import java.util.List;


public interface PedidoProveedorRepositorio extends JpaRepository<PedidoProveedor, Integer> {

    public List<PedidoProveedor> findByProveedor(Proveedor proveedor);
}

