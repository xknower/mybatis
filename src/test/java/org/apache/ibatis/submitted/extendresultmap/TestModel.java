package org.apache.ibatis.submitted.extendresultmap;

import java.util.Objects;

public class TestModel {

  private String a;
  private String b;

  public TestModel() {
  }

  public TestModel(String a, String b) {
    this.a = a;
    this.b = b;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

  public String getB() {
    return b;
  }

  public void setB(String b) {
    this.b = b;
  }

  @Override
  public int hashCode() {
    return Objects.hash(a, b);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    TestModel other = (TestModel) obj;
    if (!Objects.equals(a, other.a)) {
      return false;
    }
    if (!Objects.equals(b, other.b)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "TestModel [a=" + a + ", b=" + b + "]";
  }
}
