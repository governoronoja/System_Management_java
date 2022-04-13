/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.babcle.mavenproject1.Controller;

import com.babcle.mavenproject1.entities.Addresses;
import com.babcle.mavenproject1.entities.Customers;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author clement
 */

@Named
@RequestScoped
public class HomeController {
    
    @Inject
    DataService dataservice;
    
    private List<Addresses> customerAddresses;
    
    private Optional<Customers> currentCustomer;
    
    @PostConstruct
    public void initialize () {
        
       String customername = "Adams";
       this.currentCustomer = dataservice.getCustomer(customername);
       this.currentCustomer.ifPresent(customer-> {
           
           this.customerAddresses = dataservice.getAddresses(customer);
       
       });
    }
    
    public Customers getCurrentCustomer() {
        
        return this.currentCustomer.orElse(null);
    }

    public List<Addresses> getCustomerAddress() {
        return customerAddresses;
    }
    
}
