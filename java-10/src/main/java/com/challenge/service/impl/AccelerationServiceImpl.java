package com.challenge.service.impl;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccelerationServiceImpl implements AccelerationServiceInterface {

  private final AccelerationRepository repository;

  @Override
  public Acceleration save(Acceleration object) {
    return repository.save(object);
  }

  @Override
  public Optional<Acceleration> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Acceleration> findByCompanyId(Long companyId) {
    return repository.findByCompanyId(companyId);
  }


}
