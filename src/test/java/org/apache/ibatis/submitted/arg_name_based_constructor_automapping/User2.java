package org.apache.ibatis.submitted.arg_name_based_constructor_automapping;

import org.apache.ibatis.annotations.Param;

public class User2 {

  private final Integer userId;
  private final String name;

  public User2(Integer userId, @Param("userName") String name) {
    this.userId = userId;
    this.name = name;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }
}
