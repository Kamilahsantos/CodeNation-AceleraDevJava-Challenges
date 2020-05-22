package com.challenge.repository;

import com.challenge.entity.CandidateId;
import com.challenge.entity.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface CandidateRepository extends JpaRepository <Candidate,CandidateId> {

  @Query("select c from Candidate c where c.id.acceleration.id = :id")
  List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);

  @Query("select c from Candidate c where c.id.user.id= :userId and c.id.company.id= :companyId and  c.id.acceleration.id= :accelerationId")
  Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);

  @Query("select c from Candidate c where c.id.company.id = :id")
  List<Candidate> findByCompanyId(@Param("id") Long companyId);


}
