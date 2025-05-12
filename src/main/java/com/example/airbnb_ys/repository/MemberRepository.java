package com.example.airbnb_ys.repository;

import com.example.airbnb_ys.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
