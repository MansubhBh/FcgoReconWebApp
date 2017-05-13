/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "C_PROJECT")
public class C_PROJECT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "BUD_YEAR")
    private String BUD_YEAR;
    @Column(name = "PROJECT_CODE")
    private String PROJECT_CODE;
    @Column(name = "PROJECT_EDESC")
    private String PROJECT_EDESC;
    @Column(name = "PROJECT_NDESC")
    private String PROJECT_NDESC;

    public C_PROJECT() {
    }

    public C_PROJECT(int ID,String BUD_YEAR, String PROJECT_CODE, String PROJECT_EDESC, String PROJECT_NDESC) {
        this.ID = ID;
        this.BUD_YEAR = BUD_YEAR;
        this.PROJECT_CODE = PROJECT_CODE;
        this.PROJECT_EDESC = PROJECT_EDESC;
        this.PROJECT_NDESC = PROJECT_NDESC;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    

    public String getBUD_YEAR() {
        return BUD_YEAR;
    }

    public void setBUD_YEAR(String BUD_YEAR) {
        this.BUD_YEAR = BUD_YEAR;
    }

    public String getPROJECT_CODE() {
        return PROJECT_CODE;
    }

    public void setPROJECT_CODE(String PROJECT_CODE) {
        this.PROJECT_CODE = PROJECT_CODE;
    }

    public String getPROJECT_EDESC() {
        return PROJECT_EDESC;
    }

    public void setPROJECT_EDESC(String PROJECT_EDESC) {
        this.PROJECT_EDESC = PROJECT_EDESC;
    }

    public String getPROJECT_NDESC() {
        return PROJECT_NDESC;
    }

    public void setPROJECT_NDESC(String PROJECT_NDESC) {
        this.PROJECT_NDESC = PROJECT_NDESC;
    }
    
    
    
}
