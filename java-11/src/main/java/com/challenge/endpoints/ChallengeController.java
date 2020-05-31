package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/challenge")
public class ChallengeController {

  @Autowired
  private ChallengeService service;

  @GetMapping
  public ResponseEntity<List<Challenge>> findByAccelerationNameAndCompanyId(
    @RequestParam Long accelerationId,
    @RequestParam Long userId){

    return ResponseEntity.ok(service.findByAccelerationIdAndUserId(accelerationId, userId));
  }

}
