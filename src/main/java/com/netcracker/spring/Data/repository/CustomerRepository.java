package com.netcracker.spring.Data.repository;

import com.netcracker.spring.Data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT DISTINCT c.district FROM Customer c")
    List<String> findDistinctDistrict();

    List<Customer> findByDistrict(String distring);
}
