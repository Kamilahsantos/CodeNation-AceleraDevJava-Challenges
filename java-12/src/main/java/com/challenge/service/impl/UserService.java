package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface,UserDetailsService {

  private UserRepository userRepository;

  @Override
  public Optional<User> findById(Long userId) {
    return userRepository.findById(userId);
  }

  @Override
  public List<User> findByAccelerationName(String name) {
    return userRepository.findByCandidatesIdAccelerationName(name);
  }

  @Override
  public List<User> findByCompanyId(Long companyId) {
    return userRepository.findByCandidatesIdCompanyId(companyId);
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByEmail(username).get();
  }

}
