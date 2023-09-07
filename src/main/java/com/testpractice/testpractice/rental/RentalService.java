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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    @Transactional
    public ResponseEntity<?> insertRental(RentalRequestDto rentalRequestDto) {
        Book rentalBook = bookRepository.findByBookNameAndRental(rentalRequestDto.getBook().getBookName(),false).orElseThrow(() ->
                new NullPointerException("해당 책은 대여되었거나 구비되어 있지 않습니다."));
        LocalDate now = LocalDate.now();

        // 현재 시간
        LocalTime nowTime = LocalTime.now();

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm");

        String formatedNow = nowTime.format(formatter);

        String date = nowTime + " " + formatedNow;


        Member member = memberRepository.findById(rentalRequestDto.getMember().getId()).orElseThrow(()->new NullPointerException("아이디가 존재하지 않습니다."));


            Rental rental = Rental.builder()
                    .member(member)
                    .book(rentalBook)
                    .rentalDate(date)
                    .build();

            rentalRepository.save(rental);

        rentalBook.rentalBook();


        return new ResponseEntity<>("대출이 완료 되었습니다", HttpStatus.OK);

    }

    @Transactional
    public ResponseEntity<?> checkRental(String bookName) {

        Book book = bookRepository.findAllByBookNameAndRental(bookName,false).orElseThrow(()->new NullPointerException("해당 책은 대여되었거나 구비되어 있지 않습니다."));

        return new ResponseEntity<>("해당 책은 대여가 가능합니다", HttpStatus.OK);

    }
    @Transactional
    public ResponseEntity<?> receiveBook(RentalRequestDto rentalRequestDto) {
        int x=0;

        Rental rental= new Rental();

        LocalDate now = LocalDate.now();

        // 현재 시간
        LocalTime nowTime = LocalTime.now();

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH : mm");

        String formatedNow = nowTime.format(formatter);

        String date = nowTime + " " + formatedNow;

        Book receiveBook= bookRepository.findByIdAndRental(rentalRequestDto.getBook().getId(), true).orElseThrow(()->new NullPointerException("해당 책은 대여되지 않았습니다."));
        Rental receiveRentalBook= rentalRepository.findById(rentalRequestDto.getBook().getId()).orElseThrow(()->new NullPointerException("해당 책은 대여되지 않았습니다."));

        receiveBook.receiveBook();
        receiveRentalBook.receiveBook(date);

        return new ResponseEntity<>("반납이 완료 되었습니다", HttpStatus.OK);

    }
}
