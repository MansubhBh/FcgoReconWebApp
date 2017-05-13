/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "DECSTSA_TRANSACTION")
public class DECSTSA_TRANSACTION {
    
    @Id
    @Column(name = "ID")
    private int ID;
    @Column(name = "BUD_YEAR")
    private String BUD_YEAR;
    @Column(name = "PO_CODE")
    private String PO_CODE;
    @Column(name = "ACC_CODE")
    private String ACC_CODE;
    @Column(name = "PO_REQUEST_NO")
    private String PO_REQUEST_NO;
    @Column(name = "CHEQUE_NO")
    private String CHEQUE_NO;
    @Column(name = "PAYEE_CODE")
    private String PAYEE_CODE;
    @Column(name = "ECONOMIC_CODE5")
    private String ECONOMIC_CODE5;
    @Column(name = "SOURCE_TYPE_CODE")
    private String SOURCE_TYPE_CODE;
    @Column(name = "DONOR_CODE")
    private String DONOR_CODE;
    @Column(name = "EXPENDITURE_AMOUNT")
    private String EXPENDITURE_AMOUNT;
    @Column(name = "CHEQUE_TRAN_EDATE")
    private String CHEQUE_TRAN_EDATE;

    public DECSTSA_TRANSACTION() {
    }

    public DECSTSA_TRANSACTION(int ID, String BUD_YEAR, String PO_CODE, String ACC_CODE, String PO_REQUEST_NO, String PAYEE_CODE, String SOURCE_TYPE_CODE, String DONOR_CODE, String EXPENDITURE_AMOUNT) {
        this.ID = ID;
        this.BUD_YEAR = BUD_YEAR;
        this.PO_CODE = PO_CODE;
        this.ACC_CODE = ACC_CODE;
        this.PO_REQUEST_NO = PO_REQUEST_NO;
        this.PAYEE_CODE = PAYEE_CODE;
        this.SOURCE_TYPE_CODE = SOURCE_TYPE_CODE;
        this.DONOR_CODE = DONOR_CODE;
        this.EXPENDITURE_AMOUNT = EXPENDITURE_AMOUNT;
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

    public String getPO_CODE() {
        return PO_CODE;
    }

    public void setPO_CODE(String PO_CODE) {
        this.PO_CODE = PO_CODE;
    }

    public String getACC_CODE() {
        return ACC_CODE;
    }

    public void setACC_CODE(String ACC_CODE) {
        this.ACC_CODE = ACC_CODE;
    }

    public String getPO_REQUEST_NO() {
        return PO_REQUEST_NO;
    }

    public void setPO_REQUEST_NO(String PO_REQUEST_NO) {
        this.PO_REQUEST_NO = PO_REQUEST_NO;
    }

    public String getCHEQUE_NO() {
        return CHEQUE_NO;
    }

    public void setCHEQUE_NO(String CHEQUE_NO) {
        this.CHEQUE_NO = CHEQUE_NO;
    }

    public String getPAYEE_CODE() {
        return PAYEE_CODE;
    }

    public void setPAYEE_CODE(String PAYEE_CODE) {
        this.PAYEE_CODE = PAYEE_CODE;
    }

    public String getECONOMIC_CODE5() {
        return ECONOMIC_CODE5;
    }

    public void setECONOMIC_CODE5(String ECONOMIC_CODE5) {
        this.ECONOMIC_CODE5 = ECONOMIC_CODE5;
    }

    public String getSOURCE_TYPE_CODE() {
        return SOURCE_TYPE_CODE;
    }

    public void setSOURCE_TYPE_CODE(String SOURCE_TYPE_CODE) {
        this.SOURCE_TYPE_CODE = SOURCE_TYPE_CODE;
    }

    public String getDONOR_CODE() {
        return DONOR_CODE;
    }

    public void setDONOR_CODE(String DONOR_CODE) {
        this.DONOR_CODE = DONOR_CODE;
    }

    public String getEXPENDITURE_AMOUNT() {
        return EXPENDITURE_AMOUNT;
    }

    public void setEXPENDITURE_AMOUNT(String EXPENDITURE_AMOUNT) {
        this.EXPENDITURE_AMOUNT = EXPENDITURE_AMOUNT;
    }

    public String getCHEQUE_TRAN_EDATE() {
        return CHEQUE_TRAN_EDATE;
    }

    public void setCHEQUE_TRAN_EDATE(String CHEQUE_TRAN_EDATE) {
        this.CHEQUE_TRAN_EDATE = CHEQUE_TRAN_EDATE;
    }
    
    
    
    
    
}
