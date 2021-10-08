package com.FeriaVirtual.fv.DAO;

import com.FeriaVirtual.fv.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> listar();

    void eliminar(String rut);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

    void actualizar(Usuario usuario);
    
}
