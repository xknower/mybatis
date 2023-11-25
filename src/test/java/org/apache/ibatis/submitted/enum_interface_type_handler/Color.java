package org.apache.ibatis.submitted.enum_interface_type_handler;

public enum Color implements HasValue {
  WHITE {
    @Override
    public int getValue() {
      return 1;
    }
  },
  RED {
    @Override
    public int getValue() {
      return 2;
    }
  },
  BLUE {
    @Override
    public int getValue() {
      return 3;
    }
  }
}
