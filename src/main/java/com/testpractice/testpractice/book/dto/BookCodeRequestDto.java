package com.testpractice.testpractice.book.dto;


import com.testpractice.testpractice.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCodeRequestDto {
    private int id;
    private Member member;
    private String category;
}
