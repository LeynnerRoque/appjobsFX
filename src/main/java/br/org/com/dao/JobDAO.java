package br.org.com.dao;

import br.org.com.model.Job;

import javax.persistence.TypedQuery;
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

    public Job getByTitle(String title){
        TypedQuery<Job> query = dao.em.createQuery("SELECT j FROM Job j WHERE j.title = '"+title+"'",Job.class);
        Job job = query.getSingleResult();

        return job;
    }
}
