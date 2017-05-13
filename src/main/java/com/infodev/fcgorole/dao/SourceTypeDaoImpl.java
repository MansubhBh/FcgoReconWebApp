/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_SOURCE_TYPE;
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
public class SourceTypeDaoImpl implements SourceTypeDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public List<C_SOURCE_TYPE> getAll() {
    session = sessionFactory.openSession();
    List<C_SOURCE_TYPE> sourcetypelist = session.createQuery("SELECT s from C_SOURCE_TYPE s").list();
    session.close();
    return sourcetypelist;
        
    }

    @Override
    public String getSourceByCode(String code) {
    for(C_SOURCE_TYPE s :getAll()){
        if(s.getSOURCE_TYPE_CODE().equals(code)){
            return s.getSOURCE_TYPE_EDESC();
        }
    }
    
    return null;
    }
    
    
    
}
