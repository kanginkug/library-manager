package com.testpractice.testpractice.member;

import com.testpractice.testpractice.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsById(String memberId);

    boolean existsByIdAndPassword(String memberId, String password);

    Optional<Member> findByIdAndPassword(String memberId, String password);


    Optional<Member> findById(String memberId);

    boolean existsByPhone(String phone);

    boolean findAdminById(String memberId);

}
