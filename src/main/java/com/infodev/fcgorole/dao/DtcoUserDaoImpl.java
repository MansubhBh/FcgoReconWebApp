/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.DtcoUser;
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
public class DtcoUserDaoImpl implements DtcoUserDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private DistrictDao districtDao;
    private Session session;
    
    @Override
    public List<DtcoUser> getAll() {
        session = sessionFactory.openSession();
    List<DtcoUser> dtcouserlist = session.createQuery("SELECT d from DtcoUser d").list();
    session.close();
    return dtcouserlist;
    }

    @Override
    public String getDistrictByUsername(String username) {
    for(DtcoUser d : getAll()){
        if(d.getUser().getUsername().equals(username)){
           int distcode = d.getDistrict_code();
           String distname = districtDao.getDistrictByCode(distcode);
           return distname;
        }
    }
    return null;
    }
    
    
    
}
