package com.challenge.service.interfaces;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

import java.util.List;
import java.util.Optional;

public interface CandidateServiceInterface extends ServiceInterface<Candidate> {

    Optional<Candidate> findById(CandidateId id);

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);
}
