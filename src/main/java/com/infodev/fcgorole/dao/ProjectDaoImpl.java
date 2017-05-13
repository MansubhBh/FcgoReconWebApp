/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_PROJECT;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mansubh
 */
@Repository
public class ProjectDaoImpl implements ProjectDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public List<C_PROJECT> getAll() {
    session = sessionFactory.openSession();
    List<C_PROJECT> projectlist = session.createQuery("SELECT p from C_PROJECT p").list();
    session.close();
    return projectlist;
    }

    @Override
        public String getDescCode(String code) {
    for(C_PROJECT p : getAll()){
        if(p.getPROJECT_CODE().equals(code)){
            return p.getPROJECT_EDESC();
        }
    }
    return null;
    }
    
    
    
}
