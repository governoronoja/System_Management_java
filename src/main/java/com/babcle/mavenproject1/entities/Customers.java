/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.babcle.mavenproject1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author clement
 */

@Entity
@Table(name = "customers")
@NamedQueries ({

    @NamedQuery(name = "Customers.all", query = "select cust from Customers cust order by cust.id"),
    @NamedQuery(name = "Customers.byusername", query = "select cust from Customers cust where cust.username = :username")

})

public class Customers implements Serializable {
    
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id; 
    
    @Column (name = "firstname", nullable = false)
    private String firstname;
        
    @Column (name = "lastname", nullable = false)
    private String lastname;
    
    @Column (name = "username", nullable = false, unique = true)
    private String username;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "cust_password", nullable = false)
    private String cust_password;
    
    @Column (name = "phonenumber", nullable = false)
    private String phonenumber;
    
    @Column (name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date regData;
    
    @Column (name = "data_Of_Birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column (name = "subscription")
    private String subscription;

    public Customers() {
    }

    public Customers(Integer id) {
        this.id = id;
    }

    public Customers(Integer id, String firstname, String lastname, String username, String email, String phonenumber, Date regData, Date dateOfBirth, String subscription, String cust_password) {
        
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.regData = regData;
        this.dateOfBirth = dateOfBirth;
        this.subscription = subscription;
        this.cust_password = cust_password;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Date getRegData() {
        return regData;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubscription() {
        return subscription;
    }

    public String getCust_password() {
        return cust_password;
    }
    
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonrnumber) {
        this.phonenumber = phonrnumber;
    }

    public void setRegData(Date regData) {
        this.regData = regData;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public void setCust_password(String cust_password) {
        this.cust_password = cust_password;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customers other = (Customers) obj;
        return Objects.equals(this.id, other.id);
    }
     
    
}
