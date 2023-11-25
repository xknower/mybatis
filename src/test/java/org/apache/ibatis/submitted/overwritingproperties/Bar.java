package org.apache.ibatis.submitted.overwritingproperties;

import java.io.Serializable;

public class Bar implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long field1;

  public Bar() {
  }

  public Bar(long field1) {
    this.field1 = field1;
  }

  public Long getField1() {
    return field1;
  }

  public void setField1(Long field1) {
    this.field1 = field1;
  }
}
