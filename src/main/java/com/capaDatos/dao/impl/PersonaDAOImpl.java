package com.capaDatos.dao.impl;

import com.capaDatos.JPAUtil;
import com.capaDatos.dao.PersonaDAO;
import com.capaDatos.entidades.Persona;

import jakarta.persistence.EntityManager;

import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    private final EntityManager em;

    public PersonaDAOImpl() {
        em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();
    }

    @Override
    public void insertar(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    @Override
    public Persona buscarPorId(Integer id) {
        return em.find(Persona.class, id);
    }

    @Override
    public List<Persona> buscarTodos() {
        return em.createQuery(
                "SELECT p FROM Persona p",
                Persona.class
        ).getResultList();
    }

    @Override
    public void actualizar(Persona persona) {
        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(Integer id) {
        em.getTransaction().begin();

        Persona persona = em.find(Persona.class, id);

        if (persona != null) {
            em.remove(persona);
        }

        em.getTransaction().commit();
    }
}
