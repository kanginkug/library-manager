package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import com.testpractice.testpractice.member.MemberRepository;
import com.testpractice.testpractice.rental.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public ResponseEntity<?> insertBook(BookRequestDto bookRequestDto) {

        Member trueMem = memberRepository.findById(bookRequestDto.getMember().getId())
                .orElseThrow(()->new NullPointerException("아이디가 존재하지 않습니다"));

        if(!trueMem.isAdmin() || !trueMem.isLogin()){
            throw new IllegalArgumentException("관리자가 아니거나 로그아웃 상태입니다.");
        }

        Book book = Book.builder()
                .bookName(bookRequestDto.getBookName())
                .author(bookRequestDto.getAuthor())
                .bookCode(bookRequestDto.getBookCode())
                .build();

        bookRepository.save(book);

        return new ResponseEntity<>("등록이 완료 되었습니다", HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<?> updateBook(BookRequestDto bookRequestDto) {

        Member trueMem = memberRepository.findById(bookRequestDto.getMember().getId())
                .orElseThrow(()->new NullPointerException("아이디가 존재하지 않습니다"));

        if(!trueMem.isAdmin() || !trueMem.isLogin()){
            throw new IllegalArgumentException("관리자가 아니거나 로그아웃 상태입니다.");
        }

        Book book =  bookRepository.findById(bookRequestDto.getBookId()).orElseThrow(() -> new NullPointerException("해당 도서를 찾을 수 없습니다."));

        book.updateBook(bookRequestDto);

        return new ResponseEntity<>("수정이 완료 되었습니다", HttpStatus.OK);
    }


}
