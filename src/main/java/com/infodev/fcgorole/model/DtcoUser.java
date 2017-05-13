/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "dtco_users",catalog = "fcgorecondb")
public class DtcoUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dtco_user_id")
    private int dtco_user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",nullable = false)
    private User user;
    @Column(name="district_code")
    private int district_code;

    public DtcoUser() {
    }

    public DtcoUser(int dtco_user_id, int district_code) {
        this.dtco_user_id = dtco_user_id;
        this.district_code = district_code;
    }

    public int getDtco_user_id() {
        return dtco_user_id;
    }

    public void setDtco_user_id(int dtco_user_id) {
        this.dtco_user_id = dtco_user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(int district_code) {
        this.district_code = district_code;
    }
    
    
    
}
