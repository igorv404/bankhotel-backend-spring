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
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Booking {
  @Id
  @GeneratedValue
  Integer id;

  @Column
  Integer roomId;

  @Column
  String name;

  @Column
  String surname;

  @Column
  String email;

  @Column
  String phone;

  @Column
  @ElementCollection
  List<String> reservationPeriod;
}
