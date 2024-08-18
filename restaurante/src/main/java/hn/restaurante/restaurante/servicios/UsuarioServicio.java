package hn.restaurante.restaurante.servicios;

import java.util.List;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.restaurante.restaurante.modelos.TipoUsuario;
import hn.restaurante.restaurante.modelos.Usuario;
import hn.restaurante.restaurante.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServicio {

    @Autowired 
    private UsuarioRepositorio usuarioRepositorio;

    public List <Usuario> obtenerTodos(){
        return this.usuarioRepositorio.findAll();
    }


    public Usuario crearNuevUsuario(Usuario NuevoUsuario){
        if(this.usuarioRepositorio.existsById(NuevoUsuario.getIdUsuario())){
            return null;
        }

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(2);
        tipoUsuario.setDescripcion("cliente");


        NuevoUsuario.setTipoUsuario(tipoUsuario);

        long now = System.currentTimeMillis();
        NuevoUsuario.setFechaCreacion(new Timestamp(now));

        return this.usuarioRepositorio.save(NuevoUsuario);
    }

    public List<Usuario> buscarPorEmailContrasena(Usuario usuario) {

        return this.usuarioRepositorio.obtenerPorEmailContrasena(usuario.getEmail(), usuario.getContrasenia());
    }

    public Usuario obtenerPorId(int id) {

        return this.usuarioRepositorio.findById(id).get();
    }

    @Transactional
    public Usuario editarUsuario(int id) {

        if(!this.usuarioRepositorio.existsById(id)) {

            return null;
        }

        Usuario usuario =  this.usuarioRepositorio.findById(id).get();
        TipoUsuario tipoUsuario = usuario.getTipoUsuario();

        if(tipoUsuario.getIdTipoUsuario() == 2) {

            this.usuarioRepositorio.darPrivilegios(id);
        } else {

            this.usuarioRepositorio.quitarPrivilegios(id);
        }

        return null;
    }
    
}
