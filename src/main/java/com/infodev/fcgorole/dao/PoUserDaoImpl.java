/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.PoUser;
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
public class PoUserDaoImpl implements PoUserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private PoDao poDao;
    private Session session;
    
    @Override
    public List<PoUser> getAll() {
    session = sessionFactory.openSession();
    List<PoUser> pouserlist = session.createQuery("SELECT p from PoUser p").list();
    session.close();
    return pouserlist;
    }

    @Override
    public String getPoByUsername(String username) {
     for(PoUser p :getAll()){
         if(p.getUser().getUsername().equals(username)){
             String pocode = p.getPo_code();
             String poname = poDao.getPoNameByCode(pocode);
             return poname;
         }
     }
     return null;
    }
    
    
    
}
