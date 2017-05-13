/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import javax.persistence.Column;    
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mansubh
 */
@Entity
@Table(name = "po_status")
public class PoStatus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "po_code")
    private String po_code;
    @Column(name = "check_flag")
    private boolean check_flag;
    @Column(name = "submit_flag")
    private boolean submit_flag;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id")
    private C_MONTH month;

    public PoStatus() {
    }

    public PoStatus(int id, String po_code, boolean check_flag, boolean submit_flag) {
        this.id = id;
        this.po_code = po_code;
        this.check_flag = check_flag;
        this.submit_flag = submit_flag;
    }

    public C_MONTH getMonth() {
        return month;
    }

    public void setMonth(C_MONTH month) {
        this.month = month;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPo_code() {
        return po_code;
    }

    public void setPo_code(String po_code) {
        this.po_code = po_code;
    }

    public boolean isCheck_flag() {
        return check_flag;
    }

    public void setCheck_flag(boolean check_flag) {
        this.check_flag = check_flag;
    }

    public boolean isSubmit_flag() {
        return submit_flag;
    }

    public void setSubmit_flag(boolean submit_flag) {
        this.submit_flag = submit_flag;
    }
    
    
    
}
