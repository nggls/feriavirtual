package com.FeriaVirtual.fv.controller;

import com.FeriaVirtual.fv.DAO.UsuarioDao;
import com.FeriaVirtual.fv.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value ="api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }


    @RequestMapping(value ="api/usuarios/{rut}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable String rut) {
        usuarioDao.eliminar(rut);
    }


    @RequestMapping(value ="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getClave());
        usuario.setClave(hash);

        usuarioDao.registrar(usuario);

    }
    @RequestMapping(value = "api/usuarios/{rut}", method = RequestMethod.PUT)
    public void actualizarUsuario(@RequestBody Usuario usuario) {
     usuarioDao.actualizar(usuario);
   }


}
