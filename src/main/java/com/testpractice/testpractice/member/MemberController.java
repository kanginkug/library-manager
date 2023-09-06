package com.testpractice.testpractice.member;

import com.testpractice.testpractice.member.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberRequestDto memberRequestDto) {

        return memberService.signup(memberRequestDto);
    }

    @GetMapping("/login")
    public ResponseEntity<?> signin(@RequestBody MemberRequestDto memberRequestDto) {

        return memberService.login(memberRequestDto);
    }


}
