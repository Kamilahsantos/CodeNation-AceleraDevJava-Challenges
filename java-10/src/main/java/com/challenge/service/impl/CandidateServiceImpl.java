package com.challenge.service.impl;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateServiceInterface {

  private final CandidateRepository repository;

  @Override
  public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
    return repository.findById(userId, companyId, accelerationId);
  }

  @Override
  public Optional<Candidate> findById(CandidateId id) {
    return repository.findById(id);
  }

  @Override
  public List<Candidate> findByAccelerationId(Long accelerationId) {
    return repository.findByAccelerationId(accelerationId);
  }

  @Override
  public List<Candidate> findByCompanyId(Long companyId) {
    return repository.findByCompanyId(companyId);
  }

  @Override
  public Candidate save(Candidate object) {
    return repository.save(object);
  }

}
