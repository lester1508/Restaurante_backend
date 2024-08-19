package hn.restaurante.restaurante.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.restaurante.restaurante.modelos.Orden;

public interface OrdenRepositorio extends JpaRepository<Orden, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE orden SET status = 'Completado' WHERE idOrden = :idOrden", nativeQuery = true)
    public void confirmarOrden(@Param("idOrden") int idOrden);
}

