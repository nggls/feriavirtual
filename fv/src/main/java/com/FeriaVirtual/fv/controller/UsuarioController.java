package com.FeriaVirtual.fv.controller;

import com.FeriaVirtual.fv.DAO.UsuarioDao;
import com.FeriaVirtual.fv.models.Usuario;
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
        usuarioDao.registrar(usuario);
    }
    //@RequestMapping(value = "api/usuarios/{rut}", method = RequestMethod.PUT)
    //public void actualizarUsuario(@RequestBody Usuario usuario) {
     //   usuarioDao.actualizar(usuario);
    //}


}
