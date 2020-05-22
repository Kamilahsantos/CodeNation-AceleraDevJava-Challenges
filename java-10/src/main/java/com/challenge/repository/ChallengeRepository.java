package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

  @Query("select c from Challenge c where c.id = (select a.challenge.id from Acceleration a where a.id = :accelerationId) and c.id = (select s.id.challenge.id from Submission s where s.id.user.id = :userId)")
  List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
