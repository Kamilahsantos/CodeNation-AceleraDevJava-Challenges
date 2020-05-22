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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Acceleration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column
  @Size(max = 100)
  private String name;

  @NotNull
  @Column
  @Size(max = 50)
  private String slug;

  @ManyToOne
  private Challenge challenge;

  @OneToMany(mappedBy = "id.acceleration")
  private List<Candidate> candidates;

  @CreatedDate
  private LocalDateTime createdAt;
}
