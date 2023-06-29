package com.lumtec.computo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("computo");

    public static EntityManager getEntityManger() {
        return FACTORY.createEntityManager();
    }

}
