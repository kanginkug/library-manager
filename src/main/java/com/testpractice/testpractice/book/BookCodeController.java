package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookCodeRequestDto;
import com.testpractice.testpractice.book.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books-codes")
public class BookCodeController {

    private final BookCodeService bookCodeService;

    @PostMapping()
    public ResponseEntity<?> insertBookCode(@ModelAttribute BookCodeRequestDto bookCodeRequestDto) throws Exception {

        return bookCodeService.insertBookCode(bookCodeRequestDto);
    }
}
