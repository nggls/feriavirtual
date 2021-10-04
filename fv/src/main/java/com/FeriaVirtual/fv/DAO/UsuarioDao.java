package com.FeriaVirtual.fv.DAO;

import com.FeriaVirtual.fv.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(String rut);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);

    // void actualizar(Usuario usuario);

}
