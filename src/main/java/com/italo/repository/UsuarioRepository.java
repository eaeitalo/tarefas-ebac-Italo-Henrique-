package com.repository;

import com.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Transactional
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public List<Usuario> listarTodos() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }

    public Usuario buscarPorId(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    public void atualizar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public void excluir(Long id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }
}