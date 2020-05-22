package com.challenge.entity;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CandidateId implements Serializable {

  @ManyToOne
  private User user;

  @ManyToOne
  private Acceleration acceleration;

  @ManyToOne
  private Company company;

}
