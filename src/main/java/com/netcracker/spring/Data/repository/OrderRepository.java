package com.netcracker.spring.Data.repository;

import com.netcracker.spring.Data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT DISTINCT o.date FROM Order o")
    List<Date> findDistinctDate();

    List<Order> findByCostGreaterThanEqual(Integer cost);


    List<Order> findByDateGreaterThanEqual(Date date);


}
