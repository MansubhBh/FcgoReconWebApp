/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.C_DISTRICT;
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
public class DistrictDaoImpl implements DistrictDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    @Override
    public String getDistrictByCode(int code) {
    for(C_DISTRICT d : getAll()){
        if(d.getDistCode() == code){
            return d.getDistrictName();
        }
    }
        return null;
    }
    
    private List<C_DISTRICT> getAll(){
        session = sessionFactory.openSession();
        List<C_DISTRICT> districtlist = session.createQuery("SELECT d FROM C_DISTRICT d").list();
        session.close();
        return districtlist;
    }
    
    
    
    
}
