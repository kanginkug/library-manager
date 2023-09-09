package com.testpractice.testpractice.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpractice.testpractice.book.BookCode;
import com.testpractice.testpractice.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class BookRequestDto {

    private String bookName;
    private String author;
    private BookCode bookCode;
    private Long bookId;
    private Member member;

    public BookRequestDto(){

    }
}
