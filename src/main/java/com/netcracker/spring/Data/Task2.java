package com.netcracker.spring.Data;

import com.netcracker.spring.Data.repository.BookRepository;
import com.netcracker.spring.Data.repository.CustomerRepository;
import com.netcracker.spring.Data.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Task2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Task2.class, args);
        BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
        CustomerRepository customerRepository=applicationContext.getBean(CustomerRepository.class);
        OrderService orderService=(OrderService)applicationContext.getBean("orderService");

        bookRepository.findDistinctPrice().forEach(System.out::println);
        bookRepository.findDistinctName().forEach(System.out::println);

        customerRepository.findDistinctDistrict().forEach(System.out::println);

        orderService.findDistrictMonth().forEach(System.out::println);

    }
}
