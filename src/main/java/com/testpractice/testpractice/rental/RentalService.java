package com.testpractice.testpractice.rental;

import com.testpractice.testpractice.book.Book;
import com.testpractice.testpractice.book.BookCode;
import com.testpractice.testpractice.book.BookRepository;
import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import com.testpractice.testpractice.member.MemberRepository;
import com.testpractice.testpractice.rental.dto.RentalRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    @Transactional
    public ResponseEntity<?> insertRental(Book book, Member member) {

        LocalDate now = LocalDate.now();

        // 현재 시간
        LocalTime nowTime = LocalTime.now();

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm");

        String formatedNow = nowTime.format(formatter);

        String date = nowTime + " " + formatedNow;

        Long bookId=0L;

            if(!memberRepository.existsById(member.getId())){
                return new ResponseEntity<>("존재하지 않는 아이디입니다.", HttpStatus.BAD_REQUEST);
            }

            if(memberRepository.findByLogin(member.getId())){
                return new ResponseEntity<>("로그인 상태가 아닙니다.", HttpStatus.BAD_REQUEST);
            }

            bookId = bookRepository.findIdByBookName(book.getBookName());

            if(rentalRepository.findReceiveByBookId(bookId) == true){
                return new ResponseEntity<>("대출 되어 있는 책입니다.", HttpStatus.BAD_REQUEST);
            }



            Rental rental = Rental.builder()
                    .member(member)
                    .book(book)
                    .rentalDate(date)
                    .receive(true)
                    .build();

            rentalRepository.save(rental);

        return new ResponseEntity<>("대출이 완료 되었습니다", HttpStatus.OK);

    }

    public ResponseEntity<?> checkRental(String bookName) {

        List<Rental> bookIds = rentalRepository.findAllByBookName(bookName);

        return new ResponseEntity<>(bookIds, HttpStatus.OK);

    }

    public ResponseEntity<?> receiveBook(Long bookId) {

        LocalDate now = LocalDate.now();

        // 현재 시간
        LocalTime nowTime = LocalTime.now();

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm");

        String formatedNow = nowTime.format(formatter);

        String date = nowTime + " " + formatedNow;

        Rental rentalData = rentalRepository.findAllByBookId(bookId);

        Rental rental = Rental.builder()
                .member(null)
                .receiveDate(date)
                .receive(false)
                .build();

        rentalRepository.save(rental);

        return new ResponseEntity<>("반납이 완료 되었습니다", HttpStatus.OK);
        
    }
}
