package hn.restaurante.restaurante.controladores;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.restaurante.restaurante.modelos.Reservacion;
import hn.restaurante.restaurante.modelos.TipoPlatillo;
import hn.restaurante.restaurante.servicios.ReservacionServicio;

@RestController
@RequestMapping("/api/reservaciones")
public class ReservacionControlador {
    
    @Autowired
    private ReservacionServicio reservacionServicio;


    @GetMapping("/obtener/todos")
    public List <Reservacion> obtenerTodos(){
        return this.reservacionServicio.obtenerTodos();
    }

    @PostMapping("/crear/reservacion")
        public Reservacion crearNuevaReservacion(@RequestBody Reservacion nuevaReservacion){
            return this.reservacionServicio.crearNuevaReservacion(nuevaReservacion);
        }

}
