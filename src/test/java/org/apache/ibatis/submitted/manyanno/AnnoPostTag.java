package org.apache.ibatis.submitted.manyanno;

public class AnnoPostTag {

  private final int id;
  private final String name;

  public AnnoPostTag(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
