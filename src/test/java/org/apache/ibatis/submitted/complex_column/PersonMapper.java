package org.apache.ibatis.submitted.complex_column;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {

  Person getWithoutComplex(Long id);

  Person getWithComplex(Long id);

  Person getParentWithComplex(Person person);

  // @formatter:off
  @Select({
      "SELECT id, firstName, lastName, parent_id, parent_firstName, parent_lastName",
      "FROM Person",
      "WHERE id = #{id,jdbcType=INTEGER}"
    })
  // @formatter:on
  @ResultMap("personMapComplex")
  Person getWithComplex2(Long id);

  // @formatter:off
  @Select({
      "SELECT id, firstName, lastName, parent_id, parent_firstName, parent_lastName",
      "FROM Person",
      "WHERE id = #{id,jdbcType=INTEGER}"
    })
  // @formatter:on
  @ResultMap("org.apache.ibatis.submitted.complex_column.PersonMapper.personMapComplex")
  Person getWithComplex3(Long id);

  // @formatter:off
  @Select({
      "SELECT id, firstName, lastName, parent_id, parent_firstName, parent_lastName",
      "FROM Person",
      "WHERE id = #{id,jdbcType=INTEGER}"
    })
  @Results({
      @Result(id = true, column = "id", property = "id"),
      @Result(property = "parent", column = "{firstName=parent_firstName,lastName=parent_lastName}", one = @One(select = "getParentWithParamAttributes"))
    })
  // @formatter:on
  Person getComplexWithParamAttributes(Long id);

  // @formatter:off
  @Select("SELECT id, firstName, lastName, parent_id, parent_firstName, parent_lastName"
      + " FROM Person"
      + " WHERE firstName = #{firstName,jdbcType=VARCHAR}"
      + " AND lastName = #{lastName,jdbcType=VARCHAR}"
      + " LIMIT 1")
  // @formatter:on
  Person getParentWithParamAttributes(@Param("firstName") String firstName, @Param("lastName") String lastname);

}
