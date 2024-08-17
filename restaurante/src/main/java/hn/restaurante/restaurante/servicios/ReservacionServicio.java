package hn.restaurante.restaurante.servicios;

import java.sql.Timestamp;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.Reservacion;
import hn.restaurante.restaurante.repositorios.ReservacionRepositorio;


@Service
public class ReservacionServicio {

    @Autowired 
    private ReservacionRepositorio reservacionRepositorio;

    private static final int duracion_reserva = 2;

    public List <Reservacion> obtenerTodos(){
      return this.reservacionRepositorio.findAll();
    }

      public Reservacion crearNuevaReservacion(Reservacion nuevaReservacion){
        if(this.reservacionRepositorio.existsById(nuevaReservacion.getIdReservacion())){
            return null;
        }
        calcularFechaFinal(nuevaReservacion);
        return this.reservacionRepositorio.save(nuevaReservacion);
    }
    
    private void calcularFechaFinal(Reservacion reservacion) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(reservacion.getFechaInicio());
        cal.add(Calendar.HOUR, duracion_reserva);
        reservacion.setFechaFinal(new Timestamp(cal.getTime().getTime()));
    }
   
}
