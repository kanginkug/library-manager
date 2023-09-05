package com.testpractice.testpractice.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false)
    private String bookName;

    @Column
    private String author;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKCODE_ID")
    private BookCode bookCode;

}
