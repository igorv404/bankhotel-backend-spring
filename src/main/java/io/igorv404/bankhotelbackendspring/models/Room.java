package io.igorv404.bankhotelbackendspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Room {
  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String name;

  @Column(length = 1000)
  @ElementCollection
  private List<String> images;

  @Column(length = 5000)
  private String description;

  @Column(length = 1000)
  @ElementCollection
  private List<String> services;
}
