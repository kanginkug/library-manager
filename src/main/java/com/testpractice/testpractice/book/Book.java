package com.testpractice.testpractice.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bookName;

    @Column
    private String author;

    @Column
    @ColumnDefault("false")
    private boolean rental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKCODE_CATEGORY")
    private BookCode bookCode;



    public void updateBook(BookRequestDto BookRequestDto) {
        this.bookName = BookRequestDto.getBookName();
        this.author = BookRequestDto.getAuthor();
        this.bookCode = BookRequestDto.getBookCode();
    }

    public void receiveBook() {
        this.rental = false;
    }


    public void rentalBook(){
        this.rental = true;
    }




}
