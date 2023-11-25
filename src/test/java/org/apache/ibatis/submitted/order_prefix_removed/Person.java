package org.apache.ibatis.submitted.order_prefix_removed;

import java.io.Serializable;

public class Person implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer id;
  private String firstName;
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
