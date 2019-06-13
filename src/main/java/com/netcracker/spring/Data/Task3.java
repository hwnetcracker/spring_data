package com.netcracker.spring.Data;

import com.netcracker.spring.Data.repository.BookRepository;
import com.netcracker.spring.Data.repository.CustomerRepository;
import com.netcracker.spring.Data.repository.ShopRepository;
import com.netcracker.spring.Data.service.BookService;
import com.netcracker.spring.Data.service.CustomerService;
import com.netcracker.spring.Data.service.ShopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Task3 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Task3.class, args);
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        CustomerRepository customerRepository=applicationContext.getBean(CustomerRepository.class);
        CustomerService customerService=(CustomerService) applicationContext.getBean("customerService");
        ShopService shopService=(ShopService)applicationContext.getBean("shopService");


        customerService.findLastNameAndSaleByDistrict("Нижегородский").forEach(System.out::println);

        shopService.findNamesByDistricts("Сормово","Советский").forEach(System.out::println);

        bookService
                .findByNameLikeOrPriceGreaterThanOrderByNamePriceDesc("%Windows%",20000)
                .forEach(System.out::println);


    }
}
