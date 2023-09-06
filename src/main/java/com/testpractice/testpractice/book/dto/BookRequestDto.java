package com.testpractice.testpractice.book.dto;

import com.testpractice.testpractice.book.BookCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequestDto {

    private String bookName;
    private String author;
    private BookCode bookCode;
}
