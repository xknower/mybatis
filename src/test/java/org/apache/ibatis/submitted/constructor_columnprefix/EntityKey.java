package org.apache.ibatis.submitted.constructor_columnprefix;

import java.util.Objects;

public class EntityKey {
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    EntityKey other = (EntityKey) obj;
    if (!Objects.equals(id, other.id)) {
      return false;
    }
    return true;
  }
}
