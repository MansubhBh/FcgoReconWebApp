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
public class DECSTSA_TRANSACTION_ENTRY {
    
    
    private String budYear;
    private int monthId;
    private String accCode;
    private String ecoCode;
    private String donorCode;
    private String sourceType;
    private String poCode;
    private String amount;

    public DECSTSA_TRANSACTION_ENTRY() {
    }

    public DECSTSA_TRANSACTION_ENTRY( String budYear, int monthId, String accCode, String ecoCode, String donorCode, String sourceType, String amount) {
        
        this.budYear = budYear;
        this.monthId = monthId;
        this.accCode = accCode;
        this.ecoCode = ecoCode;
        this.donorCode = donorCode;
        this.sourceType = sourceType;
        this.amount = amount;
    }
    
    

  

    public String getBudYear() {
        return budYear;
    }

    public void setBudYear(String budYear) {
        this.budYear = budYear;
    }

    public int getMonthId() {
        return monthId;
    }

    public void setMonth(int monthId) {
        this.monthId = monthId;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public String getEcoCode() {
        return ecoCode;
    }

    public void setEcoCode(String ecoCode) {
        this.ecoCode = ecoCode;
    }

    public String getDonorCode() {
        return donorCode;
    }

    public void setDonorCode(String donorCode) {
        this.donorCode = donorCode;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }
    
    
    
}
