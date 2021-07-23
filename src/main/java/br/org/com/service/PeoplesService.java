package br.org.com.service;

import br.org.com.dao.PeoplesDAO;
import br.org.com.model.Peoples;

import java.util.List;

public class PeoplesService {
    PeoplesDAO dao = new PeoplesDAO();

    public Boolean create(Peoples peoples){
        try {
            dao.create(peoples);
            return true;
        }catch (Exception e){
            System.out.println("Error on create");
            return false;
        }
    }

    public List<Peoples> getAll(){
        return dao.getAll();
    }

    public Boolean update(Peoples peoples){
        try{
        dao.update(peoples);
        return true;
        }catch (Exception e){
            System.out.println("Error on update Object"+e.getMessage());
            return false;
        }
    }




}
