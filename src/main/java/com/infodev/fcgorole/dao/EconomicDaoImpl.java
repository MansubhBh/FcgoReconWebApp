/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_ECONOMIC5;
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
public class EconomicDaoImpl implements EconomicDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public List<C_ECONOMIC5> getAll() {
    session = sessionFactory.openSession();
    List<C_ECONOMIC5> economiclist = session.createQuery("SELECT e from C_ECONOMIC5 e").list();
    session.close();
    return economiclist;
        
    }

    @Override
    public String getEconomicByCode(String code) {
    for(C_ECONOMIC5 e : getAll()){
        if(e.getECONOMIC_CODE5().equals(code)){
            return e.getECONOMIC_EDESC5();
        }
    }
    return null;
    }
    
    
}
