package com.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDTO {

    private Long challengeId;
    private String userId;
    private BigDecimal score;
    private String createdAt;

}
