/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.DECSTSA_TRANSACTION;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mansubh
 */
@Repository
public class TransactionDaoImpl implements TransactionDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    @Override
    public List<DECSTSA_TRANSACTION> getAll() {
    
        session = sessionFactory.openSession();
        List<DECSTSA_TRANSACTION> transactionlist = session.createQuery("SELECT t from DECSTSA_TRANSACTION t").list();
        session.close();
        return transactionlist;
    }
    
    
    
}
