/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalcollect.infra2.landscapetool.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="customer")
public class Customer implements Serializable{


   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   @Id
   @Column(name="id")
   private Integer id;

   @Column(name="name")
   private String name;

   @Column(name="balance")
   private double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


   public Customer() {
   }

    
}
