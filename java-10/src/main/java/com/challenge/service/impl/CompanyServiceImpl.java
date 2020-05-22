package com.challenge.service.impl;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyServiceInterface {

  private final CompanyRepository repository;

  @Override
  public Company save(Company object) {
    return repository.save(object);
  }


  @Override
  public List<Company> findByAccelerationId(Long accelerationId) {
    return repository.findByAccelerationId(accelerationId);
  }

  @Override
  public Optional<Company> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Company> findByUserId(Long userId) {
    return repository.findByUserId(userId);
  }


}
