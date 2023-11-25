package org.apache.ibatis.submitted.bringrags;

import java.util.ArrayList;
import java.util.List;

public class SimpleObject {

  private final String id;
  private final List<SimpleChildObject> simpleChildObjects;

  public SimpleObject(String id) {
    this.id = id;
    this.simpleChildObjects = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public List<SimpleChildObject> getSimpleChildObjects() {
    return simpleChildObjects;
  }

}
