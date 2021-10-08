package com.FeriaVirtual.fv.controller;

import com.FeriaVirtual.fv.DAO.UsuarioDao;
import com.FeriaVirtual.fv.models.Usuario;
import com.FeriaVirtual.fv.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {


    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value ="api/usuarios", method = RequestMethod.GET)
    public List<Usuario> listar(@RequestHeader(value = "Authorization") String token) {

        if (!validarToken(token)) { return null; }

        return usuarioDao.listar();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }


    @RequestMapping(value ="api/usuarios/{rut}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable String rut) {
        if (!validarToken(token)) { return; }
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
