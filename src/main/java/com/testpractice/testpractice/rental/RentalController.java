package com.testpractice.testpractice.rental;

import com.testpractice.testpractice.book.Book;
import com.testpractice.testpractice.book.BookCode;
import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import com.testpractice.testpractice.member.dto.MemberRequestDto;
import com.testpractice.testpractice.rental.dto.RentalRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping()
    public ResponseEntity<?> insertRental(Book book, Member member) throws Exception {

        return rentalService.insertRental( book, member);
    }

    @GetMapping("/{bookName}")
    public ResponseEntity<?> checkRental(@PathVariable("bookName") String bookName) {

        return rentalService.checkRental(bookName);
    }

    @PostMapping("/receiveBook")
    public ResponseEntity<?> receiveBook(Long bookId) throws Exception {

        return rentalService.receiveBook(bookId);
    }
}
