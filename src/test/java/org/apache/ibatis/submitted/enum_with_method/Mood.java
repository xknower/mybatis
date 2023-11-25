package org.apache.ibatis.submitted.enum_with_method;

public enum Mood {
  GOOD(1) {
    @Override
    public String getMessage() {
      return "Yeehaw";
    }
  },
  BAD(2) {
    @Override
    public String getMessage() {
      return "whatevs";
    }
  };

  private int value;

  private Mood(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static Mood fromValue(int i) {
    for (Mood t : values()) {
      if (t.value == i) {
        return t;
      }
    }
    throw new IllegalArgumentException("Unknown value for Mood: " + i);
  }

  public abstract String getMessage();
}
