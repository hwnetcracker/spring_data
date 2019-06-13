package com.netcracker.spring.Data;

import com.netcracker.spring.Data.repository.BookRepository;
import com.netcracker.spring.Data.repository.OrderRepository;
import com.netcracker.spring.Data.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class Task5 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Task5.class, args);
        BookRepository bookRepository = applicationContext.getBean(BookRepository.class);

        OrderService orderService=(OrderService)applicationContext.getBean("orderService");
        OrderRepository orderRepository=applicationContext.getBean(OrderRepository.class);

//        orderService.findByCostGreaterThanEqual(60000).forEach(System.out::println);
//
//        orderService.findByDateLessThanEqual(new Date(2019,3,1)).forEach(System.out::println);
        orderService.findBySaleExceptDistrict(10,15,"Автозаводский").forEach(System.out::println);


    }
}
