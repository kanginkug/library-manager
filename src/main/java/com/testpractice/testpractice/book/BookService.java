package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public ResponseEntity<?> insertBook(BookRequestDto bookRequestDto, BookCode bookCode) {
        Book book = Book.builder()
                .bookName(bookRequestDto.getBookName())
                .author(bookRequestDto.getAuthor())
                .bookCode(bookCode)
                .build();

        bookRepository.save(book);

        return new ResponseEntity<>("등록이 완료 되었습니다", HttpStatus.OK);
    }
}
