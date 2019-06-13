package com.netcracker.spring.Data.repository;

import com.netcracker.spring.Data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT DISTINCT b.price FROM Book b")
    List<Integer> findDistinctPrice();

    @Query("SELECT DISTINCT b.name FROM Book b")
    List<String> findDistinctName();

    List<Book>  findByNameLikeOrPriceGreaterThanOrderByNameAscPriceDesc(String nameLike,Integer price);
}
