package co.edu.eam.sistemasdistribuidos.borrownotificator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "users_notification_data")
@Entity
public class UserNotificationData implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

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
