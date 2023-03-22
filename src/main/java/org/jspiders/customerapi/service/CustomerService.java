package org.jspiders.customerapi.service;

import org.jspiders.customerapi.model.Customer;
import org.jspiders.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    //add new customer into database table
    public void insertCustomer(Customer customer){
        repository.save(customer);
    }

    //get all customers
    public List<Customer> getAllCustomers(){
        List<Customer> customerList=repository.findAll();
        return customerList;
    }

    //get customer by id
    public Customer getByCustomerId(int id){
        return repository.findById(id).orElse(null);
    }

    //get customer by name
    public List<Customer> getByCustomerName(String name){
        return repository.findByCustomerName(name);
    }
    
    //get customer by email
    public List<Customer> getByCustomerEmail(String email){
        return repository.findByCustomerEmail(email);
    }

    //get customer id having age greater than ?(user)
    public List<Customer> getByCustomerIdWhereAgeIsGreaterThan(int age){
        return repository.findByCustomerAgeGreaterThan(age);
    }

    //get customer having purchase less than ?(user)
    public List<Customer> getByCustomerIdWhereTotalPurchaseIsLessThan(double amt){
        return repository.findByTotalPurchaseLessThan(amt);
    }

    //returns the list of customer having name=? and age=?
    public List<Customer> getCustomerNameAndAge(String name,int age){
       return repository.findByCustomerNameAndCustomerAge(name,age);
    }

    //returns the list of customer having age between ? and ?
    public List<Customer> getCustomerHavingAgeBetween(int age1,int age2){
       return repository.findByCustomerAgeBetween(age1,age2);
    }

    public List<Customer> viewCustomers(String name){
        return repository.viewCustomers(name);
    }

    public List<String> showCustomerName(int age, double amt){
        return repository.showCustomerName(age,amt);
    }

    public List<String> showCustomerNameWhichPresentCharacters(String character){
        return repository.showCustomerNameWhichPresentCharacters(character);
    }

    public List<String> showCustomerNameWhichStartWithCharacters(String character){
        return repository.showCustomerNameWhichStartWithCharacters(character);
    }

    public List<String> showCustomerNameWhichEndWithCharacters(String character){
        return repository.showCustomerNameWhichEndWithCharacters(character);
    }

}
