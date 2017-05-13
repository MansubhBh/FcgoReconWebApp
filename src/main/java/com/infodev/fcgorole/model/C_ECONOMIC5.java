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
@Table(name = "C_ECONOMIC5")
public class C_ECONOMIC5 {
    
    
    @Id
    @Column(name = "ECONOMIC_CODE5")
    private String ECONOMIC_CODE5;
    @Column(name = "ECONOMIC_NDESC5")
    private String ECONOMIC_NDESC5;
    @Column(name = "ECONOMIC_EDESC5")
    private String ECONOMIC_EDESC5;

    public C_ECONOMIC5() {
    }

    public C_ECONOMIC5(String ECONOMIC_CODE5, String ECONOMIC_NDESC5, String ECONOMIC_EDESC5) {
        this.ECONOMIC_CODE5 = ECONOMIC_CODE5;
        this.ECONOMIC_NDESC5 = ECONOMIC_NDESC5;
        this.ECONOMIC_EDESC5 = ECONOMIC_EDESC5;
    }

    public String getECONOMIC_CODE5() {
        return ECONOMIC_CODE5;
    }

    public void setECONOMIC_CODE5(String ECONOMIC_CODE5) {
        this.ECONOMIC_CODE5 = ECONOMIC_CODE5;
    }

    public String getECONOMIC_NDESC5() {
        return ECONOMIC_NDESC5;
    }

    public void setECONOMIC_NDESC5(String ECONOMIC_NDESC5) {
        this.ECONOMIC_NDESC5 = ECONOMIC_NDESC5;
    }

    public String getECONOMIC_EDESC5() {
        return ECONOMIC_EDESC5;
    }

    public void setECONOMIC_EDESC5(String ECONOMIC_EDESC5) {
        this.ECONOMIC_EDESC5 = ECONOMIC_EDESC5;
    }
    
    
    
    
}
