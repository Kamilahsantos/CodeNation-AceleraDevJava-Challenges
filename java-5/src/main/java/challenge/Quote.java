package challenge;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

@Table(name = "scripts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quote {

  @Id
  Integer id;

  @Column
  Integer episode;

  @Column
  String episodeName;

  @Column
  String segment;

  @Column
  String type;

  @Column
  String actor;

  @Column
  String character;

  @Column
  String detail;

  @Column
  String recordDate;

  @Column
  String series;

  @Column
  String transmissionDate;

  public void setQuote(String quote) {
    detail = quote;
  }

  public String getQuote() {
    return detail;
  }



}
