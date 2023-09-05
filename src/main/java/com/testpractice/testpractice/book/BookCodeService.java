package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookCodeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookCodeService {

    private final BookCodeRepository bookCodeRepository;
    @Transactional
    public ResponseEntity<?> insertBookCode(BookCodeRequestDto bookCodeRequestDto) {

        BookCode bookCode = BookCode.builder()
                .id(bookCodeRequestDto.getId())
                .category(bookCodeRequestDto.getCategory())
                .build();

        bookCodeRepository.save(bookCode);

        return new ResponseEntity<>("등록이 완료 되었습니다", HttpStatus.OK);
    }
}
