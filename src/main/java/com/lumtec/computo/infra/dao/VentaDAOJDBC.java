package com.lumtec.computo.infra.dao;

import com.lumtec.computo.infra.model.Venta;

import javax.persistence.EntityManager;
import java.util.List;

public class VentaDAOJDBC implements VentaDAO {

    private EntityManager em;

    public VentaDAOJDBC(EntityManager em) {
        this.em = em;
    }

    @Override
    public void vender(Venta venta) {
        em.persist(venta);
    }

    @Override
    public List<Venta> getVentasFinanzas() {
        String jpql = "SELECT P FROM Venta AS P";
        return em.createQuery(jpql, Venta.class).getResultList();
    }

    @Override
    public List<Venta> getVentasFinanzasMensual(String mes) {
        String jpql = "SELECT P FROM Venta AS P WHERE P.mes= :mes";
        return em.createQuery(jpql, Venta.class).setParameter("mes", mes).getResultList();
    }
}
