package com.testpractice.testpractice.rental;

import com.testpractice.testpractice.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
        Boolean findReceiveByBookName(String bookName);


}
