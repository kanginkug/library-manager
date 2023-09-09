package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookCodeRequestDto;
import com.testpractice.testpractice.book.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books-codes")
public class BookCodeController {

    private final BookCodeService bookCodeService;

    @PostMapping()
    public ResponseEntity<?> insertBookCode(@RequestBody BookCodeRequestDto bookCodeRequestDto) throws Exception {

        return bookCodeService.insertBookCode(bookCodeRequestDto);
    }
}
