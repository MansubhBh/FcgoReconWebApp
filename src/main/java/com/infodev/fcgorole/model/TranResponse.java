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
public class TranResponse {
    
   private String poCode;
   private String expenditure_amount;
   private String ecoCode;
   private String ecoName;
   private String donorCode;
   private String donorName;
   private String chequeNo;
   private String sourceCode;
   private String sourceType; 

    public TranResponse() {
    }

    public TranResponse(String poCode, String expenditure_amount, String ecoCode, String donorCode, String chequeNo, String sourceCode) {
        this.poCode = poCode;
        this.expenditure_amount = expenditure_amount;
        this.ecoCode = ecoCode;
        this.donorCode = donorCode;
        this.chequeNo = chequeNo;
        this.sourceCode = sourceCode;
    }

    public String getEcoName() {
        return ecoName;
    }

    public void setEcoName(String ecoName) {
        this.ecoName = ecoName;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    
    

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getExpenditure_amount() {
        return expenditure_amount;
    }

    public void setExpenditure_amount(String expenditure_amount) {
        this.expenditure_amount = expenditure_amount;
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

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
   
   
    
}