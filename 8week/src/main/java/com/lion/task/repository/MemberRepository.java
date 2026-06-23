package com.lion.task.repository;

import com.lion.task.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);
}
