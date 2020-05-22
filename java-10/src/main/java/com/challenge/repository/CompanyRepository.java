package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Query("select c.id.company from Candidate c where c.id.user.id = :id")
  List<Company> findByUserId(@Param("id") Long userId);

  @Query("select distinct c.id.company from Candidate c where c.id.acceleration.id = :id")
  List<Company> findByAccelerationId(@Param("id") Long accelerationId);


}
