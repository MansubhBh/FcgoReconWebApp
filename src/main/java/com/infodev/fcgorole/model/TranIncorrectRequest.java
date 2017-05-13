/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

/**
 *
 * @author mansubh
 */
public class TranIncorrectRequest {
    private String bud_year;
    private String economicCode;
    private String accCode;
    private String donorCode;
    private String poCode;

    public TranIncorrectRequest() {
    }

    public TranIncorrectRequest(String bud_year, String economicCode, String donorCode, String poCode,String accCode) {
        this.bud_year = bud_year;
        this.economicCode = economicCode;
        this.donorCode = donorCode;
        this.poCode = poCode;
        this.accCode = accCode;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }
    
    

    public String getBud_year() {
        return bud_year;
    }

    public void setBud_year(String bud_year) {
        this.bud_year = bud_year;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    public String getDonorCode() {
        return donorCode;
    }

    public void setDonorCode(String donorCode) {
        this.donorCode = donorCode;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }
    
    
    
}
