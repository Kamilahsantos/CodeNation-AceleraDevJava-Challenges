package com.challenge.service.impl;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionServiceInterface {

  private final SubmissionRepository repository;

  @Override
  public Submission save(Submission object) {
    return repository.save(object);
  }

  @Override
  public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
    BigDecimal score = repository.findHigherScoreByChallengeId(challengeId);
    return  score == null ? BigDecimal.ZERO : score;
  }

  @Override
  public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
    return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
  }


}
