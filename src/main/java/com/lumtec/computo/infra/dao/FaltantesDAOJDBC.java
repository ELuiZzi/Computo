package com.lumtec.computo.infra.dao;


import com.lumtec.computo.infra.model.Faltante;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.*;
import java.util.List;

public class FaltantesDAOJDBC implements FaltantesDAO {

    private final EntityManager em;

    public FaltantesDAOJDBC(EntityManager em) {
        this.em = em;
    }

    @Override
    public void nuevoFaltante(Faltante faltante) {
        em.persist(faltante);
    }

    @Override
    public void actualizarFaltante(Faltante faltante) {
        em.merge(faltante);
    }

    @Override
    public Faltante getFaltantePorNombre(String nombre) {
        String jpql = "SELECT P FROM Faltante AS P WHERE P.producto.nombre= :nombre";
        Faltante faltante = null;
        try {
            faltante = em.createQuery(jpql, Faltante.class).setParameter("nombre", nombre).getSingleResult();
        } catch (NoResultException ex) {
            JOptionPane.showMessageDialog(null, "El faltante no se encuentra registrado");
            throw new RuntimeException(ex);
        }
        return faltante;
    }

    @Override
    public List<Faltante> getListaFaltantes() {
        String jpql = "SELECT P FROM Faltante AS P";
        return em.createQuery(jpql, Faltante.class).getResultList();
    }


}
