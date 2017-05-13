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
@Table(name = "C_DISTRICT")
public class C_DISTRICT {
    
    @Id
    @Column(name = "DISTRICT_CODE")
    private int distCode;
    @Column(name = "SUB_DISTRICT_CODE")
    private int subDistCode;
    @Column(name = "DISTRICT_EDESC")
    private String districtName;

    public C_DISTRICT() {
    }

    public C_DISTRICT(int distCode, int subDistCode, String districtName) {
        this.distCode = distCode;
        this.subDistCode = subDistCode;
        this.districtName = districtName;
    }

    public int getDistCode() {
        return distCode;
    }

    public void setDistCode(int distCode) {
        this.distCode = distCode;
    }

    public int getSubDistCode() {
        return subDistCode;
    }

    public void setSubDistCode(int subDistCode) {
        this.subDistCode = subDistCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
    
    
}
