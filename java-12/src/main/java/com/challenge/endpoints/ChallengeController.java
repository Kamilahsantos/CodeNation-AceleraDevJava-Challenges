package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChallengeController {

    private ChallengeService service;

    @GetMapping("/challenge")
    public List<Challenge> findAll(@RequestParam Long accelerationId, @RequestParam Long userId) {
        return service.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
