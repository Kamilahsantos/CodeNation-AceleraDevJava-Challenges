package com.challenge.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@EntityListeners(AuditingEntityListener.class)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Challenge {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @NotNull
  @Size(max = 100)
  private String name;

  @Column
  @NotNull
  @Size(max = 50)
  private String slug;

  @OneToMany(mappedBy = "challenge")
  private List<Acceleration> accelerations;

  @OneToMany(mappedBy = "id.challenge")
  private List<Submission> submissions;

  @CreatedDate
  @Column
  private LocalDateTime createdAt;

}
