package com.netcracker.spring.Data.service;

import com.netcracker.spring.Data.repository.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service("bookService")
@RequiredArgsConstructor
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<String> findByNameLikeOrPriceGreaterThanOrderByNamePriceDesc(String nameLike,Integer price){
        return bookRepository.findByNameLikeOrPriceGreaterThanOrderByNameAscPriceDesc(nameLike, price)
                .stream()
                .map(x-> "name="+x.getName()+" price="+x.getPrice())
                .collect(Collectors.toList());
    }
}
