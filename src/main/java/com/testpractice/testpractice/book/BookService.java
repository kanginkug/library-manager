package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import com.testpractice.testpractice.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public ResponseEntity<?> insertBook(BookRequestDto bookRequestDto, BookCode bookCode) {
        Book book = Book.builder()
                .bookName(bookRequestDto.getBookName())
                .author(bookRequestDto.getAuthor())
                .bookCode(bookCode)
                .build();

        bookRepository.save(book);

        return new ResponseEntity<>("등록이 완료 되었습니다", HttpStatus.OK);
    }

    public ResponseEntity<?> updateBook(Long bookId, BookRequestDto bookRequestDto, String memberId) {

        Member member = memberRepository.findAllById(memberId).orElseThrow(()->new NullPointerException("아이디가 존재하지 않습니다."));

        if(member.isLogin() == false || member.isAdmin()== false){
            throw new IllegalArgumentException("로그인 상태가 아니거나 관리자가 아닙니다.");
        }

        Book book = Book.builder()
                .bookName(bookRequestDto.getBookName())
                .bookCode(bookRequestDto.getBookCode())
                .author(bookRequestDto.getAuthor())
                .build();

        return new ResponseEntity<>("수정이 완료 되었습니다", HttpStatus.OK);
    }
}
