package org.jspiders.customerapi.repository;

import org.jspiders.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByCustomerName(String name);
    List<Customer> findByCustomerEmail(String email);
    List<Customer> findByCustomerAgeGreaterThan(int age);
    List<Customer> findByTotalPurchaseLessThan(double amt);
    List<Customer> findByCustomerNameAndCustomerAge(String name,int age);
    List<Customer> findByCustomerAgeBetween(int age1,int age2);

    //Writing JPQL to fetch customers
    @Query("select c from Customer c where c.customerName=:name")
    List<Customer> viewCustomers(@Param(value = "name")String name);

    //Write JPQL to fetch customer names having age<? and amt>=?
    @Query("select c.customerName from Customer c where c.customerAge<:age and c.totalPurchase>=:amt")
    List<String> showCustomerName(@Param(value = "age") int age,@Param(value = "amt") double amt);

    //Write JPQL to fetch customer names whose name contains given characters
    @Query("select c.customerName from Customer c where c.customerName like %:character%")
    List<String> showCustomerNameWhichPresentCharacters(@Param(value = "character") String character);

    //Write JPQL to fetch customer names whose name starts with specific character
    @Query("select c.customerName from Customer c where c.customerName like :character%")
    List<String> showCustomerNameWhichStartWithCharacters(@Param(value = "character") String character);

    //Write JPQL to fetch customer names whose name end with specific character
    @Query("select c.customerName from Customer c where c.customerName like %:character")
    List<String> showCustomerNameWhichEndWithCharacters(@Param(value = "character") String character);

}
