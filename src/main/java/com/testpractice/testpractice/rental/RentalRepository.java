package com.testpractice.testpractice.rental;

import com.testpractice.testpractice.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    Optional<Rental> findById(Long bookId);
}
