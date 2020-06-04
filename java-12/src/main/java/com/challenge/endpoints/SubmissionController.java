package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubmissionController {

    private SubmissionService service;
    private SubmissionMapper mapper;


    @GetMapping("/submission")
    public List<SubmissionDTO> findAll(@RequestParam Long challengeId, @RequestParam Long accelerationId) {
        return mapper.map(service.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }


}
