/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "C_DONOR")
public class C_DONOR {
    
    @Id
    @Column(name="DONOR_CODE")
    private String DONOR_CODE;
    @Column(name = "DONOR_NDESC")
    private String DONOR_NDESC;
    @Column(name = "DONOR_EDESC")
    private String DONOR_EDESC;

    public C_DONOR() {
    }

    public C_DONOR(String DONOR_CODE, String DONOR_NDESC, String DONOR_EDESC) {
        this.DONOR_CODE = DONOR_CODE;
        this.DONOR_NDESC = DONOR_NDESC;
        this.DONOR_EDESC = DONOR_EDESC;
    }

    public String getDONOR_CODE() {
        return DONOR_CODE;
    }

    public void setDONOR_CODE(String DONOR_CODE) {
        this.DONOR_CODE = DONOR_CODE;
    }

    public String getDONOR_NDESC() {
        return DONOR_NDESC;
    }

    public void setDONOR_NDESC(String DONOR_NDESC) {
        this.DONOR_NDESC = DONOR_NDESC;
    }

    public String getDONOR_EDESC() {
        return DONOR_EDESC;
    }

    public void setDONOR_EDESC(String DONOR_EDESC) {
        this.DONOR_EDESC = DONOR_EDESC;
    }
    
    
    
}
