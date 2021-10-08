package com.FeriaVirtual.fv.controller;
import com.FeriaVirtual.fv.DAO.UsuarioDao;
import com.FeriaVirtual.fv.models.Usuario;
import com.FeriaVirtual.fv.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value ="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

            Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
            if (usuarioLogueado != null){

                String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getRut()), usuarioLogueado.getCorreo());
                return tokenJwt;
            }
            return "FAIL";
        }

}
