package org.apache.ibatis.submitted.enumtypehandler_on_annotation;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.submitted.enumtypehandler_on_annotation.Person.PersonType;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

/**
 * @since #444
 *
 * @author Kazuki Shimizu
 */
public interface PersonMapper {

  // @formatter:off
  @ConstructorArgs({
        @Arg(column = "id", javaType = Integer.class, id = true)
      , @Arg(column = "firstName", javaType = String.class)
      , @Arg(column = "lastName", javaType = String.class)
      // target for test (ordinal number -> Enum constant)
      , @Arg(column = "personType", javaType = PersonType.class, typeHandler = EnumOrdinalTypeHandler.class)
    })
  // @formatter:on
  @Select("SELECT id, firstName, lastName, personType FROM person WHERE id = #{id}")
  Person findOneUsingConstructor(int id);

  // @formatter:off
  @Results({
      // target for test (ordinal number -> Enum constant)
      @Result(property = "personType", column = "personType", typeHandler = EnumOrdinalTypeHandler.class)
    })
  // @formatter:on
  @Select("SELECT id, firstName, lastName, personType FROM person WHERE id = #{id}")
  Person findOneUsingSetter(int id);

  // @formatter:off
  @TypeDiscriminator(
      // target for test (ordinal number -> Enum constant)
      column = "personType", javaType = PersonType.class, typeHandler = EnumOrdinalTypeHandler.class,
      // Switch using enum constant name(PERSON or EMPLOYEE) at cases attribute
      cases = {
            @Case(value = "PERSON", type = Person.class, results = {@Result(property = "personType", column = "personType", typeHandler = EnumOrdinalTypeHandler.class)})
          , @Case(value = "EMPLOYEE", type = Employee.class, results = {@Result(property = "personType", column = "personType", typeHandler = EnumOrdinalTypeHandler.class)})
        })
  // @formatter:on
  @Select("SELECT id, firstName, lastName, personType FROM person WHERE id = #{id}")
  Person findOneUsingTypeDiscriminator(int id);

}
