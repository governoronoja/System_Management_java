/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.babcle.mavenproject1.Controller;

import com.babcle.mavenproject1.entities.Addresses;
import com.babcle.mavenproject1.entities.Customers;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author clement
 */

@ApplicationScoped
public class DataService {
    
    @PersistenceContext (unitName = "com.BabCle_mavenproject1")
    EntityManager em;
    
    @Transactional
    public Customers creatCustomer(Integer id, String firstname, String lastname, String username, String email, String phonenumber,  Date regDate, Date dateOfBirth, String subscription, String cust_password ) {
    
        Customers newCustomer = new Customers(id, firstname, lastname, username, email, phonenumber, regDate, dateOfBirth, subscription, cust_password);
        
        em.persist(newCustomer);
        
        em.flush();
        
        return newCustomer;
    
}
     @Transactional
    public Addresses createAddress(Long id, String address, String address2, String unit_num, String state, String city, String zipcode, Customers customer) {
            
         Addresses newCusAdd = new Addresses(id, address, address2, unit_num, state, city, zipcode, customer);
         
         em.persist(newCusAdd);
         em.flush();
         
         return newCusAdd;
    }
    
    public List<Customers>getAllCustomers (){
        
        return em.createNamedQuery("Customers.all", Customers.class).getResultList();
        
    }
    
    public Optional<Customers> getCustomer(String username) {
        
        
        return em.createNamedQuery("Customers.byusername", Customers.class)
                                   .setParameter("username", username)
                                   .getResultList()
                                   .stream()
                                   .findFirst();
    }
    
    public List<Addresses> getAddresses (Customers customer){
        
        return em.createNamedQuery("CusAdd.byCustomers",  Addresses.class)
                                    .setParameter("customerId", customer.getId())  
                                    .getResultList();
        
    }
     
    
}
