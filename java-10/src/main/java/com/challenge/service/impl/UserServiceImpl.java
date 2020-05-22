package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

  private final UserRepository repository;


  @Override
  public User save(User object) {
    object.setCreatedAt(LocalDateTime.now());
    return repository.save(object);
  }

  @Override
  public List<User> findByCompanyId(Long companyId) {
    return repository.findByCompanyId(companyId);
  }

  @Override
  public List<User> findByAccelerationName(String name) {
    return repository.findByAccelerationName(name);
  }

  @Override
  public Optional<User> findById(Long userId) {
    return repository.findById(userId);
  }





}
