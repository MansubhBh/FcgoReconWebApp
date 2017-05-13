/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_MONTH;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mansubh
 */
@Repository
public class MonthDaoImpl implements MonthDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    

    @Override
    public List<C_MONTH> getAll() {
    session = sessionFactory.openSession();
    List<C_MONTH> monthlist = session.createQuery("SELECT m from C_MONTH m").list();
    session.close();
    return monthlist;
    }

    @Override
    public C_MONTH getById(int id) {
        
//    session = sessionFactory.openSession();
//        Query query = session.createQuery("FROM C_MONTH m WHERE m.MONTH_ID = :month_id");
//        query.setParameter("month_id", id);
//        C_MONTH m = (C_MONTH)query.uniqueResult();
//       session.close();
//       return m;

for(C_MONTH m : getAll()){
    if(m.getMonth_id() == id){
        return m;
    }
}
return null;
    }
    
    
    
}
