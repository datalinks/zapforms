/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalcollect.infra2.landscapetool.model;

/**
 *
 * @author Chris
 */
public class AjaxResponseHolder {
    
    private String creditcardUserName;
    private String exceptionMsg;

    public String getCreditcardUserName() {
        return creditcardUserName;
    }

    public void setCreditcardUserName(String creditcardUserName) {
        this.creditcardUserName = creditcardUserName;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public int getCreditcardUserId() {
        return creditcardUserId;
    }

    public void setCreditcardUserId(int creditcardUserId) {
        this.creditcardUserId = creditcardUserId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    private int creditcardUserId;
    private double balance;
}
