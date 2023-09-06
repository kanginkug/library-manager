package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<?> insertBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {

        return bookService.insertBook(bookRequestDto);
    }

    @PatchMapping("/updates-books")
    public ResponseEntity<?> updateBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {

        return bookService.updateBook(bookRequestDto);
    }



}
