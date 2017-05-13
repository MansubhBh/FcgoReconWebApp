/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mansubh
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public User findByUserName(String username) {
    
        List<User> users = new ArrayList<>(); 
       users = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=?").setParameter(0, username).list();
        if(users.size() > 0){
            return users.get(0);
        }else{
            return null;
        }   
    }
}
