/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.babcle.mavenproject1.Controller;

import com.babcle.mavenproject1.entities.Customers;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author clement
 */
@Named
@RequestScoped
public class CustomersController {
    
    @Inject
    DataService dataservice;
    
    private List<Customers> allCustomers;
    
    @PostConstruct
    public void  initialize (){
        
        this.allCustomers = dataservice.getAllCustomers();
        
    }

    public List<Customers> getAllCustomers() {
        return allCustomers;
    }
    
}
