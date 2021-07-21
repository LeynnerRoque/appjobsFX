package br.org.com.service;

import br.org.com.dao.EnterpriseDAO;
import br.org.com.model.Enterprise;

import java.util.List;

public class EnterpriseService {

    EnterpriseDAO enterpriseDAO = new EnterpriseDAO();

    public Boolean create(Enterprise enterprises){

        try {
            if(enterprises.getId() != null){
                enterpriseDAO.create(enterprises);
            }else{
                enterpriseDAO.create(enterprises);
            }
            enterpriseDAO.create(enterprises);
            return true;

        }catch (Exception e){
            System.out.println("Error in create: "+e.getMessage());
            return false;
        }

    }


    public List<Enterprise> getAll(){
        return enterpriseDAO.getAll();
    }

    public Enterprise getByfoundationName(String name){
        return enterpriseDAO.getByFoundationName(name);
    }

    public void update(Enterprise enterprise){
        enterpriseDAO.update(enterprise);
    }
}
