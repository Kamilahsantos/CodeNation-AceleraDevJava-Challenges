package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/submission")
public class SubmissionController {
  @Autowired
  private SubmissionMapper mapper;

  @Autowired
  private SubmissionService service;

  @GetMapping
  public ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(
    @RequestParam Long challengeId,
    @RequestParam Long accelerationId) {

    List<SubmissionDTO> dto = mapper.map(service.findByChallengeIdAndAccelerationId(challengeId, accelerationId));

    return ResponseEntity.ok(dto);

  }


}
