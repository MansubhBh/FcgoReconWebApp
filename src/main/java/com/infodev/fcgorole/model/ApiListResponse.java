/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infodev.fcgorole.model;

import java.util.List;

/**
 *
 * @author mansubh
 */
public class ApiListResponse<T> {
    
    private String status;
    private String message;
    private List<T> data;

    public ApiListResponse() {
    }

    
    public ApiListResponse(String status, String message, List data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    
}
