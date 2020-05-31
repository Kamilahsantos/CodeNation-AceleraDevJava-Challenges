package com.challenge.endpoints;


import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

  @Autowired
  private AccelerationService service;

  @GetMapping("/{id}")
  public ResponseEntity<Acceleration> findById(@PathVariable Long id){
    return ResponseEntity.ok(service.findById(id).orElseThrow(() -> new RuntimeException()));
  }

  @GetMapping
  public ResponseEntity<List<Acceleration>> findByCompanyId(@RequestParam Long companyId){
    return ResponseEntity.ok(service.findByCompanyId(companyId));
  }

}
