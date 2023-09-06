package com.testpractice.testpractice.member;

import com.testpractice.testpractice.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;
    @Transactional
    public ResponseEntity<?> signup(MemberRequestDto memberRequestDto) {

        if(memberRepository.existsById(memberRequestDto.getId())){
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        if (memberRepository.existsByPhone(memberRequestDto.getPhone())) {
            throw new IllegalArgumentException("이미 등록된 핸드폰입니다.");
        }

        Member member = Member.builder()
                .id(memberRequestDto.getId())
                .memName(memberRequestDto.getMemName())
                .password(memberRequestDto.getPassword())
                .address(memberRequestDto.getAddress())
                .phone(memberRequestDto.getPhone())
                .admin(memberRequestDto.isAdmin())
                .build();

        memberRepository.save(member);

        return new ResponseEntity<>("회원가입이 완료되었습니다.", HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> login(MemberRequestDto memberRequestDto) {
         Member member = memberRepository.findByIdAndPassword(memberRequestDto.getId(),memberRequestDto.getPassword())
                 .orElseThrow(()->new NullPointerException("아이디 혹은 비밀번호가 일치하지 않습니다."));


        member.updateLogin(true);

        return new ResponseEntity<>("로그인에 성공하였습니다.", HttpStatus.OK);
        
    }
}
