package com.lumtec.computo.infra.dao;

import com.lumtec.computo.infra.model.Provedor;

import javax.persistence.EntityManager;
import java.util.List;

public class ProvedorDAOJDBC implements ProvedorDAO {

    EntityManager em;

    public ProvedorDAOJDBC(EntityManager em) {
        this.em = em;
    }

    @Override
    public Provedor getProvedorPorNombre(String nombre) {
        String jpql = "SELECT P FROM Provedor AS P WHERE P.nombre= :nombre";
        return em.createQuery(jpql, Provedor.class).setParameter("nombre", nombre).getSingleResult();


    }

    @Override
    public List<Provedor> getProvedores() {
        String jpql = "SELECT P FROM Provedor AS P";
        return em.createQuery(jpql, Provedor.class).getResultList();
    }




}
