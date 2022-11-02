package com.infnet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private EntityManagerFactory createEMF() {
        return Persistence.createEntityManagerFactory("pi");
    }

    public EntityManager createEM() {
        return createEMF().createEntityManager();
    }
}
