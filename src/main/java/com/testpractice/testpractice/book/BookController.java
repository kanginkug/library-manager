package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<?> insertBoard(@ModelAttribute BookRequestDto bookRequestDto, BookCode bookCode) throws Exception {

        return bookService.insertBook(bookRequestDto, bookCode);
    }

}
