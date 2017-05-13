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
@Table(name = "C_SOURCE_TYPE")
public class C_SOURCE_TYPE {
    
    @Id
    @Column(name = "SOURCE_TYPE_CODE")
    private String SOURCE_TYPE_CODE;
    @Column(name = "SOURCE_TYPE_NDESC")
    private String SOURCE_TYPE_NDESC;
    @Column(name = "SOURCE_TYPE_EDESC")
    private String SOURCE_TYPE_EDESC;

    public C_SOURCE_TYPE() {
    }

    public C_SOURCE_TYPE(String SOURCE_TYPE_CODE, String SOURCE_TYPE_NDESC, String SOURCE_TYPE_EDESC) {
        this.SOURCE_TYPE_CODE = SOURCE_TYPE_CODE;
        this.SOURCE_TYPE_NDESC = SOURCE_TYPE_NDESC;
        this.SOURCE_TYPE_EDESC = SOURCE_TYPE_EDESC;
    }

    public String getSOURCE_TYPE_CODE() {
        return SOURCE_TYPE_CODE;
    }

    public void setSOURCE_TYPE_CODE(String SOURCE_TYPE_CODE) {
        this.SOURCE_TYPE_CODE = SOURCE_TYPE_CODE;
    }

    public String getSOURCE_TYPE_NDESC() {
        return SOURCE_TYPE_NDESC;
    }

    public void setSOURCE_TYPE_NDESC(String SOURCE_TYPE_NDESC) {
        this.SOURCE_TYPE_NDESC = SOURCE_TYPE_NDESC;
    }

    public String getSOURCE_TYPE_EDESC() {
        return SOURCE_TYPE_EDESC;
    }

    public void setSOURCE_TYPE_EDESC(String SOURCE_TYPE_EDESC) {
        this.SOURCE_TYPE_EDESC = SOURCE_TYPE_EDESC;
    }
    
    
    
}
