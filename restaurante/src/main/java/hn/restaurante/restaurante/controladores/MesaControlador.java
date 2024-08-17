package hn.restaurante.restaurante.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Mesa;
import hn.restaurante.restaurante.modelos.Platillo;
import hn.restaurante.restaurante.servicios.MesaServicio;

@RestController
@RequestMapping("/api/mesas")
public class MesaControlador {

    @Autowired
    private MesaServicio mesaServicio;

     @GetMapping("/obtener/todos")
    public List <Mesa> obtenerTodos(){
        return this.mesaServicio.obtenerTodos();
    }

     @PostMapping("/crear/mesa")
        public Mesa crearMesa(@RequestBody Mesa nuevaMesa){
            return this.mesaServicio.crearMesa(nuevaMesa);
        }
    
}
