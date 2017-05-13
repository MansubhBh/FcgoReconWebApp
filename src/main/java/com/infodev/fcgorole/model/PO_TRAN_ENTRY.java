/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "PO_TRANSACTION_ENTRY")
public class PO_TRAN_ENTRY {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int Id;
    @Column(name = "BUD_YEAR")
    private String budYear;
    @Column(name = "PO_CODE")
    private String poCode;
    @ManyToOne
    @JoinColumn(name = "MONTH_ID")
    private C_MONTH month;
    @Column(name = "ACC_CODE")
    private String accCode;
    @Column(name = "ECONOMIC_CODE5")
    private String economicCode;
    @Column(name = "DONOR_CODE")
    private String donorCode;
    @Column(name = "SOURCE_TYPE_CODE")
    private String sourceTypeCode;
    @Column(name = "AMOUNT")
    private String Amount;
    @Column(name = "INPUT_TIME",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inputTime;

    public PO_TRAN_ENTRY() {
    }

    public PO_TRAN_ENTRY(int Id, String budYear, C_MONTH month, String accCode, String economicCode, String donorCode, String sourceTypeCode, String Amount) {
        this.Id = Id;
        this.budYear = budYear;
        this.month = month;
        this.accCode = accCode;
        this.economicCode = economicCode;
        this.donorCode = donorCode;
        this.sourceTypeCode = sourceTypeCode;
        this.Amount = Amount;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getBudYear() {
        return budYear;
    }

    public void setBudYear(String budYear) {
        this.budYear = budYear;
    }

    public C_MONTH getMonth() {
        return month;
    }

    public void setMonth(C_MONTH month) {
        this.month = month;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
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

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }
    
    
    
    
    
    
    
}
