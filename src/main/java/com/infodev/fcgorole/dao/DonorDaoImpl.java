/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_DONOR;
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
public class DonorDaoImpl implements DonorDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public List<C_DONOR> getAll() {
       session = sessionFactory.openSession();
       List<C_DONOR> donorlist = session.createQuery("SELECT d from C_DONOR d").list();
       session.close();
       return donorlist;
    }

    @Override
    public String getDonorByCode(String code) {
    for(C_DONOR d : getAll()){
        if(d.getDONOR_CODE().equals(code)){
            return d.getDONOR_EDESC();
        }
    }
    return null;
    }
    
    
    
}
