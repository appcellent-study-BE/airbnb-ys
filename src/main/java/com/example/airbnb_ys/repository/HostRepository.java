package com.example.airbnb_ys.repository;

import com.example.airbnb_ys.model.Host;
import com.example.airbnb_ys.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Integer> {
    Host findByUserId(Member userId);
}
