package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccelerationController {

    private AccelerationService service;

    @GetMapping("/acceleration/{id}")
    public Acceleration findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping("/acceleration")
    public List<Acceleration> findAll(@RequestParam Long companyId) {
        return service.findByCompanyId(companyId);
    }


}
