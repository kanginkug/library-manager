package com.testpractice.testpractice.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequestDto {

    private String bookName;
    private String author;
}
