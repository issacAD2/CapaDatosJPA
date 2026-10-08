package com.capaDatos.dao.impl;

import com.capaDatos.dao.DomicilioDAO;
import com.capaDatos.entidades.Domicilio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class DomicilioDAOImpl implements DomicilioDAO {

    private final EntityManager em;

    public DomicilioDAOImpl() {
        em = Persistence
                .createEntityManagerFactory("CapaDatosPU")
                .createEntityManager();
    }

    @Override
    public void insertar(Domicilio domicilio) {
        em.getTransaction().begin();
        em.persist(domicilio);
        em.getTransaction().commit();
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        return em.find(Domicilio.class, id);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return em.createQuery(
                "SELECT d FROM Domicilio d",
                Domicilio.class
        ).getResultList();
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        em.getTransaction().begin();
        em.merge(domicilio);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(Integer id) {
        em.getTransaction().begin();

        Domicilio domicilio = em.find(Domicilio.class, id);

        if (domicilio != null) {
            em.remove(domicilio);
        }

        em.getTransaction().commit();
    }
}