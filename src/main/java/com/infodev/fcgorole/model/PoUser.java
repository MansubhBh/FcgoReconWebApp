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
@Table(name = "po_users", catalog = "fcgorecondb")
public class PoUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_user_id")
    private int po_user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",nullable = false)
    private User user;
    @Column(name = "po_code")
    private String po_code;

    public PoUser() {
    }

    public PoUser(int po_user_id, String po_code) {
        this.po_user_id = po_user_id;
        this.po_code = po_code;
    }
    
    

    public int getPo_user_id() {
        return po_user_id;
    }

    public void setPo_user_id(int po_user_id) {
        this.po_user_id = po_user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPo_code() {
        return po_code;
    }

    public void setPo_code(String po_code) {
        this.po_code = po_code;
    }
    
    
    
    
    
}
