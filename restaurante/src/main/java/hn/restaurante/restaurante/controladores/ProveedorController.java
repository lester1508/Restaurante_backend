package hn.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Proveedor;
import hn.restaurante.restaurante.repositorios.ProveedorRepositorio;
import hn.restaurante.restaurante.servicios.ProveedorServicio;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @PostMapping("/registrar")
    public Proveedor crearProveedor(@RequestBody Proveedor nvoProveedor) {
        
        return this.proveedorServicio.crearProveedor(nvoProveedor);
    }

    @GetMapping("/obtener/todos")
    public List<Proveedor> obtenerProveedores() {
        return this.proveedorServicio.obtenerProveedores();
    }
    
    @GetMapping("/buscar")
    public Proveedor buscarProveedor(@RequestParam int idProveedor) {
        return this.proveedorServicio.buscarProveedor(idProveedor);
    }
    
    @PutMapping("/actualizar")
    public Proveedor actualizarProveedor(@RequestParam int id, @RequestBody Proveedor proveedor) {
        return this.proveedorServicio.actualizarProveedor(id, proveedor);
    }

    @DeleteMapping("/eliminar")
    public String eliminarProveedor(@RequestParam int idProveedor){
        return this.proveedorServicio.eliminarProveedor(idProveedor);
    }
    
}
