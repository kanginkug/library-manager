package com.testpractice.testpractice.book;

import com.testpractice.testpractice.book.dto.BookCodeRequestDto;
import com.testpractice.testpractice.member.Member;
import com.testpractice.testpractice.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookCodeService {

    private final BookCodeRepository bookCodeRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public ResponseEntity<?> insertBookCode(BookCodeRequestDto bookCodeRequestDto) {
        Member trueMem = memberRepository.findById(bookCodeRequestDto.getMember().getId())
                .orElseThrow(()->new NullPointerException("아이디가 존재하지 않습니다"));

        if(!trueMem.isAdmin() || !trueMem.isLogin()){
            throw new IllegalArgumentException("관리자가 아니거나 로그아웃 상태입니다.");
        }

        BookCode bookCode = BookCode.builder()
                .id(bookCodeRequestDto.getId())
                .category(bookCodeRequestDto.getCategory())
                .build();

        bookCodeRepository.save(bookCode);

        return new ResponseEntity<>("등록이 완료 되었습니다", HttpStatus.OK);
    }
}
