package org.apache.ibatis.submitted.arg_name_based_constructor_automapping;

public class User {

  private final Integer id;
  private final String name;
  private Long team;

  public User(Integer id, String name) {
    this.id = id;
    this.name = name + "!";
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setTeam(Long team) {
    this.team = team;
  }

  public Long getTeam() {
    return team;
  }
}
