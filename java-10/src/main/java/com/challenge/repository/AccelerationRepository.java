package com.challenge.repository;

import com.challenge.entity.Acceleration;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{
  @Query("select c.id.acceleration from Candidate c where c.id.company.id =:id")
  List<Acceleration> findByCompanyId (@Param("id")Long id);
}
