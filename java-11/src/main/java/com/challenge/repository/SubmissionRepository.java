package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query(" select max(s.score) from Submission s " +
            " join s.id.challenge cha " +
            " where cha.id = :challengeId ")
    Optional<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(" select s from Submission s " +
            " join s.id.challenge cha " +
            " join cha.accelerations acc " +
            " where acc.id = :accelerationId and cha.id = :challengeId ")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
