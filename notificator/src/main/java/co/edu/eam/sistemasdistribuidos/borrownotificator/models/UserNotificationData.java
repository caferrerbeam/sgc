package co.edu.eam.sistemasdistribuidos.borrownotificator.models;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "users_notification_data")
@Entity
public class UserNotificationData implements Serializable {

  @Id
  private Long id;

  @Column(name="mobile_number")
  private String mobileNumber;

  private String email;

  public UserNotificationData() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
