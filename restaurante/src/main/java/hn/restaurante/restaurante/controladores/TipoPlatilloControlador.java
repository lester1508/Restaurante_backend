package hn.restaurante.restaurante.restaurante.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.TipoPlatillo;
import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.servicios.TipoPlatilloServicio;

@RestController
@RequestMapping("/api/tipoplatillos")
public class TipoPlatilloControlador {
    
    @Autowired
    private TipoPlatilloServicio tipoPlatilloServicio;

    @GetMapping("/obtener/todos")
    public List <TipoPlatillo> obtenerTodos(){
        return this.tipoPlatilloServicio.obtenerTodos();
    }

    @PostMapping("/crear/tipoplatillo")
        public TipoPlatillo crearNuevoTipoPlatillo(@RequestBody TipoPlatillo NuevoTipoPlatillo){
            return this.tipoPlatilloServicio.crearTipoPlatillo(NuevoTipoPlatillo);
        }

}
