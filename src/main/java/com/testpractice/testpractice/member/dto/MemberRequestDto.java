package com.testpractice.testpractice.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequestDto {
    private String id;
    private String password;
    private String memName;
    private String phone;
    private String address;
}
