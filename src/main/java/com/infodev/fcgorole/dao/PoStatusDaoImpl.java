/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.PoStatus;
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
public class PoStatusDaoImpl implements PoStatusDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    
    @Override
    public List<PoStatus> getAll() {
    session = sessionFactory.openSession();
    List<PoStatus> postatuslist = session.createQuery("SELECT p from PoStatus p").list();
        session.close();
        return postatuslist;
    }

    @Override
    public void insert(PoStatus p) {
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    session.save(p);
    transaction.commit();
    session.close();
    }

    @Override
    public void update(PoStatus p) {
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    session.saveOrUpdate(p);
    transaction.commit();
    session.close();
    }

    @Override
    public boolean checkPo(String pocode) {
    for(PoStatus p : getAll()){
       if(p.getPo_code().equals(pocode)){
           return true;
       } 
    }
    return false;
    }
    
    
    
    
    
}
