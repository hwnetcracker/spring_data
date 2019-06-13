package com.netcracker.spring.Data;

import com.netcracker.spring.Data.repository.BookRepository;
import com.netcracker.spring.Data.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Task4 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Task4.class, args);
        BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
        OrderService orderService=(OrderService)applicationContext.getBean("orderService");

        orderService.findNameAndShopForAll().forEach(System.out::println);
        orderService.findAllInfoForAll().forEach(System.out::println);


    }
}
