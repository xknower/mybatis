package org.apache.ibatis.submitted.foreach_map;

public class NestedBean {
  public NestedBean(Integer a, Boolean b) {
    this.a = a;
    this.b = b;
  }

  public Integer getA() {
    return a;
  }

  public Boolean getB() {
    return b;
  }

  private final Integer a;
  private final Boolean b;
}
