package co.edu.eam.sistemasdistribuidos.users.models;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "users")
@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @Column(name = "last_name")
  private String lastName;

  @Column(name="mobile_number")
  private String mobileNumber;

  private String email;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
