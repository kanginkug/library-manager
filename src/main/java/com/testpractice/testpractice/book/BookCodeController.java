package com.testpractice.testpractice.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books-codes")
public class BookCodeController {

    private final BookCodeService bookCodeService;
}
