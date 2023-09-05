package com.testpractice.testpractice.rental;

import com.testpractice.testpractice.book.Book;
import com.testpractice.testpractice.book.BookCode;
import com.testpractice.testpractice.book.dto.BookRequestDto;
import com.testpractice.testpractice.member.Member;
import com.testpractice.testpractice.member.MemberRepository;
import com.testpractice.testpractice.rental.dto.RentalRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ResponseEntity<?> insertRental(RentalRequestDto rentalRequestDto, Book book, Member member) {

            if(!memberRepository.existsById(member.getId())){
                return new ResponseEntity<>("존재하지 않는 아이디입니다.", HttpStatus.BAD_REQUEST);
            }

            if(rentalRepository.findReceiveByBookName(book.getBookName()) == true){
                return new ResponseEntity<>("대출 되어 있는 책입니다.", HttpStatus.BAD_REQUEST);
            }

            Rental rental = Rental.builder()
                    .member(member)
                    .book(book)
                    .rentalDate(rentalRequestDto.getRentalDate())
                    .receive(true)
                    .build();

            rentalRepository.save(rental);

        return new ResponseEntity<>("대여가 완료 되었습니다", HttpStatus.OK);

}

}
