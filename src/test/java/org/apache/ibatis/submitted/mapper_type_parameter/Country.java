package org.apache.ibatis.submitted.mapper_type_parameter;

public class Country {
  private Long id;

  private String name;

  public Country() {
  }

  public Country(Long id) {
    this.id = id;
  }

  public Country(Long id, String name) {
    this.id = id;
    this.name = name;
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
}
