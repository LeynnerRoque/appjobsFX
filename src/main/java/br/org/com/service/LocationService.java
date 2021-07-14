package br.org.com.service;

import br.org.com.dao.LocationDAO;
import br.org.com.model.Location;

import java.util.List;

public class LocationService {

    LocationDAO  dao = new LocationDAO();

    public Boolean create(Location local){
        try {
            dao.create(local);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Location> getAll(){
        return dao.getAll();
    }


    public Location getByStreet(String name){
        return dao.getByName(name);
    }

}
