package br.org.com.dao;

import br.org.com.model.Location;

import javax.persistence.TypedQuery;
import java.util.List;

public class LocationDAO implements IDAO<Location>{

    DAO dao = new DAO();

    @Override
    public void create(Location location) {

        dao.em.getTransaction().begin();
        dao.em.persist(location);
        dao.em.getTransaction().commit();

    }

    @Override
    public Location getOne(Integer id) {
        return null;
    }

    @Override
    public List<Location> getAll() {
        return dao.em.createQuery("SELECT l FROM Location l").getResultList();
    }

    public Location getByName(String name){
        TypedQuery<Location> query =
                dao.em.createQuery("SELECT l FROM Location l WHERE l.streetAddress = '"+name+"'",Location.class);
        Location location = query.getSingleResult();
        return location;
    }
}
