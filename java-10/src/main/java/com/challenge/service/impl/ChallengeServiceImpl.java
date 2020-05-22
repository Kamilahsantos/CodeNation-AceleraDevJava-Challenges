package com.challenge.service.impl;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeServiceInterface {

  private final ChallengeRepository repository;

  @Override
  public Challenge save(Challenge object) {
    return repository.save(object);
  }

  @Override
  public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
    return repository.findByAccelerationIdAndUserId(accelerationId, userId);
  }


}
