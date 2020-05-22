package com.challenge.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

public class User{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @NotNull
  @Column
  @Size(max=100)
  private String fullName;


  @Column
  @Email
  @NotNull
  @Size(max = 100)
  private String email;

  @Column
  @Email
  @NotNull
  @Size(max = 50)
  private String nickname;

  @Column
  @NotNull
  @Size(max = 255)
  private String password;

  @CreatedDate
  @Column
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "id.user")
  private List<Candidate> candidates;

  @OneToMany(mappedBy = "id.user")
  private List<Submission> submissions;

}
