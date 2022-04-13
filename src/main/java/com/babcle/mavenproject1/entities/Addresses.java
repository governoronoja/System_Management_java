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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author clement
 */

@Entity
@Table (name = "Addresses")
@NamedQuery(name = "CusAdd.byCustomers" , query = "select cusadd from Addresses cusadd where cusadd.customer.id =:customerId")


public class Addresses implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (name = "Street Address", nullable = false)
    private String address;
    
    @Column (name = "Street Address2")
    private String address2;
    
    @Column (name = "Unit No")
    private String unit_num;
    
    @Column (name = "State", nullable = false)
    private String state;
    
    @Column (name = "City", nullable = false)
    private String city;
    
    @Column (name = "Zip code", nullable = false)
    private String zipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Addresses() {
    }

    public Addresses(Long id) {
        this.id = id;
    }
    
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id",  nullable =false)
    private Customers customer;

    public Addresses(Long id, String address, String address2, String unit_num, String state, String city, String zipcode, Customers customer) {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.unit_num = unit_num;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.customer = customer;
    }
    
    

    public Addresses(Long id, String address, String address2, String unit_num, String state, String city, String zipcode) {
     
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.unit_num = unit_num;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getUnit_num() {
        return unit_num;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setUnit_num(String unit_num) {
        this.unit_num = unit_num;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.babcle.hervest.entities.Address[ id=" + id + " ]";
    }

    
}
