/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "C_MONTH") 
public class C_MONTH {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MONTH_ID")
    private int month_id;
    @Column(name = "MONTH_NAME")
    private String month_name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "month")
    private Set<PO_TRAN_ENTRY> transactions = new HashSet<>();

    public C_MONTH() {
    }

    public C_MONTH(int month_id, String month_name) {
        this.month_id = month_id;
        this.month_name = month_name;
    }

    public int getMonth_id() {
        return month_id;
    }

    public void setMonth_id(int month_id) {
        this.month_id = month_id;
    }

    public String getMonth_name() {
        return month_name;
    }

    public void setMonth_name(String month_name) {
        this.month_name = month_name;
    }

    public Set<PO_TRAN_ENTRY> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<PO_TRAN_ENTRY> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
     return "{'monthid : '"+month_id+",'monthname : '" + month_name + "}";
     
    }
    
    
    
    
    
    
    
}
