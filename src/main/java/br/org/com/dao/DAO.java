package br.org.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("appjobPU");
    public EntityManager em = emf.createEntityManager();

    public EntityManager getEm() {
        em = emf.createEntityManager();
        return em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
