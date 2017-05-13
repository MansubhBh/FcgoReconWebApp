/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.PO_TRAN_ENTRY;
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
public class PoEntryDaoImpl implements PoEntryDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Override
    public int insert(PO_TRAN_ENTRY p) {
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    session.save(p);
    transaction.commit();
    session.close();
    return 1; 
    }

    @Override
    public int update(PO_TRAN_ENTRY p) {
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    session.saveOrUpdate(p);
    transaction.commit();
    session.close();
    return 1;
    }

    @Override
    public int delete(int id) {
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    PO_TRAN_ENTRY p = (PO_TRAN_ENTRY)session.get(PO_TRAN_ENTRY.class, id);
    session.delete(p);
    transaction.commit();
    session.close();
    return 1;
    }

    @Override
    public List<PO_TRAN_ENTRY> getAll() {
    session = sessionFactory.openSession();
    List<PO_TRAN_ENTRY> poentrylist = session.createQuery("SELECT p from PO_TRAN_ENTRY p").list();
    session.close();
    return poentrylist;
    
    }
    
    
    
}
