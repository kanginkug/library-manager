package com.testpractice.testpractice.rental;

import com.testpractice.testpractice.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
        Boolean findReceiveByBookId(Long bookId);



        Rental findAllByBookId(Long bookId);
}
