package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.service.impl.CompanyService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService service;


  @GetMapping
  public ResponseEntity<List<Company>> findByAccelerationIdOrCompanyId(
    @RequestParam(required = false) Long accelerationId,
    @RequestParam(required = false) Long userId){

    if(accelerationId != null)
      return ResponseEntity.ok(service.findByAccelerationId(accelerationId));
    if(userId != null)
      return ResponseEntity.ok(service.findByUserId(userId));
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> findById(@PathVariable Long id){
    return ResponseEntity.ok(service.findById(id).orElseThrow(() -> new RuntimeException()));
  }



}
