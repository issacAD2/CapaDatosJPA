package com.capaDatos.dao.impl;

import com.capaDatos.dao.UsuarioDAO;
import com.capaDatos.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private final EntityManager em;

    public UsuarioDAOImpl() {
        em = Persistence
                .createEntityManagerFactory("CapaDatosPU")
                .createEntityManager();
    }

    @Override
    public void insertar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return em.createQuery(
                "SELECT u FROM Usuario u",
                Usuario.class
        ).getResultList();
    }

    @Override
    public void actualizar(Usuario usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(Integer id) {
        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, id);

        if (usuario != null) {
            em.remove(usuario);
        }

        em.getTransaction().commit();
    }
}