package com.testpractice.testpractice.member;

import com.testpractice.testpractice.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsById(String memberId);

    List<Member> findAllById(String memberId);

    boolean existsByPhone(String phone);
}
