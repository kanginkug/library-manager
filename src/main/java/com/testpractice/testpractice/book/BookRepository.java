package com.testpractice.testpractice.book;

import com.testpractice.testpractice.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Long findIdByBookName(String bookName);
}
