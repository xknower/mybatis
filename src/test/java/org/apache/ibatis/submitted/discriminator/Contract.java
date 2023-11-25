package org.apache.ibatis.submitted.discriminator;

public class Contract {
  private Integer id;
  private Owner owner;

  public Contract(Integer id, Owner owner) {
    super();
    this.id = id;
    this.owner = owner;
  }

  public Integer getId() {
    return id;
  }

  public Owner getOwner() {
    return owner;
  }
}
