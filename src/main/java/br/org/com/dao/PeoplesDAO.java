package br.org.com.dao;

import br.org.com.model.Peoples;

import java.util.List;

public class PeoplesDAO implements IDAO<Peoples> {

    DAO dao = new DAO();

    @Override
    public void create(Peoples peoples) {

        dao.em.getTransaction().begin();
        dao.em.persist(peoples);
        dao.em.getTransaction().commit();


    }

    @Override
    public Peoples getOne(Integer id) {
        return null;
    }

    @Override
    public List<Peoples> getAll() {
        return dao.em.createQuery("SELECT p FROM Peoples p").getResultList();
    }
}
