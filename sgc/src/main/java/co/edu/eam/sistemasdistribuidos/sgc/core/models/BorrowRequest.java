package co.edu.eam.sistemasdistribuidos.sgc.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "borrow_request")
public class BorrowRequest implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * id del usuario que hace el prestamo, debe existir en la bd de usuarios
   */
  private Long userId;

  /**
   * salario actual
   */
  private Double salary;

  /**
   * antiguedad en meses en el empleo actual
   */
  private Integer monthsSeniority;

  /**
   * monto a prestar
   */
  private Double amount;

  /**
   * numero de meses
   */
  private Integer installment;

  /**
   * estado de la solicitud
   * pending: estado inicial
   * rejected: rechazado en el estudio
   * approved: aprobado en el estudio
   */
  private String status;

  private Boolean notified;


  public BorrowRequest() {
    status = "pending";
    notified = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Integer getMonthsSeniority() {
    return monthsSeniority;
  }

  public void setMonthsSeniority(Integer monthsSeniority) {
    this.monthsSeniority = monthsSeniority;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Boolean getNotified() {
    return notified;
  }

  public void setNotified(Boolean notified) {
    this.notified = notified;
  }
}
