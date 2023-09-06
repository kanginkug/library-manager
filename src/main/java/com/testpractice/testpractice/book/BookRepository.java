package com.testpractice.testpractice.book;

import com.testpractice.testpractice.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

//    Long findBookByBookName(String bookName);


    Optional<Book> findByBookName(String bookName);

    Optional<Book> findById(Long bookId);

    Optional<Book> findAllByBookNameAndRental(String bookName,boolean rental);

    Optional<Book> findByBookNameAndRental(String bookName,Boolean rental);
    Optional<Book> findByIdAndRental(Long bookId,Boolean rental);

}
