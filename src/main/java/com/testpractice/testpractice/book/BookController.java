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
    public ResponseEntity<?> insertBook(@ModelAttribute BookRequestDto bookRequestDto, BookCode bookCode) throws Exception {

        return bookService.insertBook(bookRequestDto, bookCode);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook( @PathVariable("bookId") Long bookId,
                                         @ModelAttribute BookRequestDto bookRequestDto, String memberId) throws Exception {

        return bookService.updateBook(bookId, bookRequestDto, memberId);
    }

}
