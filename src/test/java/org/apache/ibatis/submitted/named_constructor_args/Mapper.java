package org.apache.ibatis.submitted.named_constructor_args;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Select;

public interface Mapper {

  // @formatter:off
  @ConstructorArgs({
      @Arg(column = "name", name = "name"),
      @Arg(id = true, column = "id", name = "id"),
      @Arg(column = "team", name = "team", javaType = String.class),
    })
  // @formatter:on
  @Select("select * from users where id = #{id}")
  User mapConstructorWithParamAnnos(Integer id);

  User mapConstructorWithParamAnnosXml(Integer id);

}
