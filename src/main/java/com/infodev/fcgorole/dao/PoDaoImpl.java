/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.dao;

import com.infodev.fcgorole.model.PayinOffice;
import java.util.ArrayList;
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
public class PoDaoImpl implements PoDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<PayinOffice> getAll() {
    session = sessionFactory.openSession();
    List<PayinOffice> polist = session.createQuery("SELECT p from PayinOffice p").list();
    session.close();
    return polist;
    }

    @Override
    public List<PayinOffice> getByDistrictCode(String code) {
        List<PayinOffice> polist = new ArrayList<>();
    for(PayinOffice p : getAll()){
       String pocode = p.getPoCode();
       String tokens[] = pocode.split("-");
       if(tokens[0].equals(code)){
           polist.add(p);
       }
    }
    
    return polist;
    }

    @Override
    public String getPoNameByCode(String code) {
    for(PayinOffice p : getAll()){
        if(p.getPoCode().equals(code)){
            return p.getPoEdesc();
        }
    }
    return null;
     }
    
    
    
}
