package org.jspiders.customerapi.controller;

import org.jspiders.customerapi.model.Customer;
import org.jspiders.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/customers")
    public void insertCustomer(@RequestBody Customer customer){
        service.insertCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return service.getAllCustomers();
    }

    @GetMapping("/customers/getbycustomerid")
    public Customer getByCustomerId(@RequestParam int id){
        return service.getByCustomerId(id);
    }

    @GetMapping("/customers/getbycustomername")
    public List<Customer> getByCustomerName(@RequestParam String name){
        return service.getByCustomerName(name);
    }

    @GetMapping("/customers/getbycustomeremail")
    public List<Customer> getByCustomerEmail(@RequestParam String email){
        return service.getByCustomerEmail(email);
    }

    @GetMapping("/customers/getbycustomerage")
    public List<Customer> getByCustomerAge(@RequestParam int age){
        return service.getByCustomerIdWhereAgeIsGreaterThan(age);
    }

    @GetMapping("/customers/getbycustomertotalpurchase")
    public List<Customer> getByCustomerTotalPurchase(@RequestParam double amt){
        return service.getByCustomerIdWhereTotalPurchaseIsLessThan(amt);
    }

    @GetMapping("/customers/getbycustomernameandage")
    public List<Customer> getCustomerNameAndAge(@RequestParam String name, int age){
       return service.getCustomerNameAndAge(name,age);
    }

    @GetMapping("/customers/getbycustomeragebetween")
    public List<Customer> getCustomerHavingAgeBetween(@RequestParam int age1,int age2){
        return service.getCustomerHavingAgeBetween(age1,age2);
    }

    @GetMapping("/customers/viewcustomer")
    public List<Customer> viewCustomers(@RequestParam String name){
        return service.viewCustomers(name);
    }

    @GetMapping("/customers/viewcustomername")
    public List<String> showCustomerName(@RequestParam int age,double amt){
        return service.showCustomerName(age,amt);
    }

    @GetMapping("/customers/viewcustomername/wherecharacteris")
    public List<String> showCustomerNameWhichPresentCharacters(@RequestParam String character){
        return service.showCustomerNameWhichPresentCharacters(character);
    }

    @GetMapping("/customers/viewcustomername/wherestartingcharacteris")
    public List<String> showCustomerNameWhichStartWithCharacters(@RequestParam String character){
        return service.showCustomerNameWhichStartWithCharacters(character);
    }

    @GetMapping("/customers/viewcustomername/whereendingcharacteris")
    public List<String> showCustomerNameWhichEndWithCharacters(@RequestParam String character){
        return service.showCustomerNameWhichEndWithCharacters(character);
    }

}
