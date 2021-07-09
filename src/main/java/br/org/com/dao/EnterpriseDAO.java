package br.org.com.dao;

import br.org.com.model.Enterprise;

import java.util.List;

public class EnterpriseDAO implements IDAO<Enterprise> {

    DAO dao = new DAO();


    @Override
    public void create(Enterprise enterprises) {
        dao.em.getTransaction().begin();
        dao.em.persist(enterprises);
        dao.em.getTransaction().commit();

    }

    @Override
    public Enterprise getOne(Integer id) {
        return null;
    }

    @Override
    public List<Enterprise> getAll() {
       return dao.em.createQuery("SELECT e FROM Enterprise e").getResultList();
    }
}
