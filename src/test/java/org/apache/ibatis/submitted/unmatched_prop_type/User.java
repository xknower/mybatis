package org.apache.ibatis.submitted.unmatched_prop_type;

import java.time.LocalDate;

public class User {
  private final Integer id;
  private final String name;
  private Birthday dob;

  public User(String id, String name) {
    super();
    this.id = Integer.valueOf(id);
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Birthday getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = new Birthday(dob);
  }

  class Birthday {
    private final LocalDate date;

    Birthday(String date) {
      this.date = LocalDate.parse(date);
    }

    public LocalDate getDate() {
      return date;
    }

  }
}
