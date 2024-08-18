package hn.restaurante.restaurante.servicios;

import hn.restaurante.restaurante.modelos.Ingrediente;
import hn.restaurante.restaurante.modelos.Proveedor;
import hn.restaurante.restaurante.repositorios.ProveedorRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServicio {
    
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    public Proveedor crearProveedor(Proveedor proveedor){

        List<Ingrediente> ingredientes = proveedor.getIngredientes();
        if (ingredientes!=null){
            for (Ingrediente ingrediente : ingredientes) {
                ingrediente.setProveedor(proveedor);
            }

            proveedor.setIngredientes(ingredientes);
        }
        
        return this.proveedorRepositorio.save(proveedor);
    }

    public String eliminarProveedor(int idProveedor){
        if(this.proveedorRepositorio.existsById(idProveedor)){
            String nombre = this.proveedorRepositorio.findById(idProveedor).get().getNombre();
            this.proveedorRepositorio.deleteById(idProveedor);
            return "Se ha eliminado el proveedor" + nombre;
        }

        return "el proveedor no existe";
    }

    public Proveedor actualizarProveedor(int idProveedor, Proveedor proveedor){
        if (this.proveedorRepositorio.findById(idProveedor)!=null){
            Proveedor proveedorActualizar = this.proveedorRepositorio.findById(idProveedor).get();
            
            proveedorActualizar.setNombre(proveedor.getNombre());
            proveedorActualizar.setTelefono(proveedor.getTelefono());

            return this.proveedorRepositorio.save(proveedorActualizar);
        }
        
        return null;
    }

    public List<Proveedor> obtenerProveedores(){

        return this.proveedorRepositorio.findAll();
    }

    public Proveedor buscarProveedor(int idProveedor){
        if(this.proveedorRepositorio.existsById(idProveedor)){
           return this.proveedorRepositorio.findById(idProveedor).get();
        }

        return null;
    }
}

