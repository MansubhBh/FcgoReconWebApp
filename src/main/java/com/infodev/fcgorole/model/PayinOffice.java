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
@Table(name="DECS_PAYING_OFFICE")
public class PayinOffice {
    
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "BUD_YEAR")
    private String budYear;
    @Column(name="PO_CODE")
    private String poCode;
    @Column(name = "PO_EDESC")
    private String poEdesc;
    @Column(name = "PO_NDESC")
    private String poNdesc;

    public PayinOffice() {
    }

    public PayinOffice(int id, String budYear, String poCode, String poEdesc, String poNdesc) {
        this.id = id;
        this.budYear = budYear;
        this.poCode = poCode;
        this.poEdesc = poEdesc;
        this.poNdesc = poNdesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBudYear() {
        return budYear;
    }

    public void setBudYear(String budYear) {
        this.budYear = budYear;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getPoEdesc() {
        return poEdesc;
    }

    public void setPoEdesc(String poEdesc) {
        this.poEdesc = poEdesc;
    }

    public String getPoNdesc() {
        return poNdesc;
    }

    public void setPoNdesc(String poNdesc) {
        this.poNdesc = poNdesc;
    }
    
    
    
    
}
