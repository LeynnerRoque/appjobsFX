package br.org.com.dao;

import br.org.com.model.Enterprise;

import javax.persistence.TypedQuery;
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

    public Enterprise getByFoundationName(String foundationName){
        TypedQuery<Enterprise> query =
                dao.em.createQuery("SELECT e FROM Enterprise e WHERE e.foundationName = '"+foundationName+"'", Enterprise.class);
        Enterprise e = query.getSingleResult();
        return e;
    }


    public void update(Enterprise enterprise){
        try{
            dao.em.getTransaction().begin();
            dao.em.merge(enterprise);
            dao.em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
