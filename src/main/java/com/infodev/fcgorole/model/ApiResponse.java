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
public class ApiResponse {

private String status;
private String message;
private String data;

    public ApiResponse() {
    }

    public ApiResponse(String status, String message, String data) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
