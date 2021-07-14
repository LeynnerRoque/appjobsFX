package br.org.com.service;

import br.org.com.dao.JobDAO;
import br.org.com.model.Job;

import java.util.List;

public class JobService {
    JobDAO dao = new JobDAO();

    public Boolean create(Job job){
        try {
            dao.create(job);
            return true;
        }catch (Exception e){
            System.out.println("Error in create");
            return false;
        }
    }


    public List<Job> getAll(){
        return dao.getAll();
    }

    public Job getByTitle(String name){
        return dao.getByTitle(name) ;
    }
}
