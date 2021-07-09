package br.org.com.dao;

import br.org.com.model.Job;

import java.util.List;

public class JobDAO implements IDAO<Job> {

    DAO dao = new DAO();

    @Override
    public void create(Job job) {
        dao.em.getTransaction().begin();
        dao.em.persist(job);
        dao.em.getTransaction().commit();


    }

    @Override
    public Job getOne(Integer id) {
        return null;
    }

    @Override
    public List<Job> getAll() {
        return dao.em.createQuery("SELECT j FROM Job j").getResultList();
    }
}
