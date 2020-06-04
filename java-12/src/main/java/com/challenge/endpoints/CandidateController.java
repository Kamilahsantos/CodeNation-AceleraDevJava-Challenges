package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CandidateController {

    private CandidateService service;
    private CandidateMapper mapper;

    @GetMapping("/candidate/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {
        return service.findById(userId, companyId, accelerationId).map(mapper::map).orElse(null);
    }

    @GetMapping("/candidate")
    public List<CandidateDTO> findAll(@RequestParam Long companyId) {
        return mapper.map(service.findByCompanyId(companyId));
    }

}
