package com.testpractice.testpractice.rental.dto;

import com.testpractice.testpractice.book.Book;
import com.testpractice.testpractice.book.BookCode;
import com.testpractice.testpractice.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@AllArgsConstructor
public class RentalRequestDto {

    private Book book;
    private Member member;

    public RentalRequestDto(){

    }


}
