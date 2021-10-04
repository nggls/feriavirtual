package com.FeriaVirtual.fv.DAO;

import com.FeriaVirtual.fv.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(String rut) {
        Usuario usuario = entityManager.find(Usuario.class, rut);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    //@Override
    // void actualizar(Usuario usuario) {
    //    String query = "UPDATE "
    //}

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "FOM Usuario WHERE rut = :rut AND clave = :clave";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("rut", usuario.getRut())
                .setParameter("clave", usuario.getClave())
                .getResultList();
        return !lista.isEmpty();

    }
}
