package org.apache.ibatis.submitted.unmatched_prop_type;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface UnmatchedPropTypeMapper {

  // javaType is required for 'id'
  @Arg(id = true, column = "id", name = "id", javaType = String.class)
  @Arg(column = "name", name = "name")
  @Result(column = "dob", property = "dob")
  @Select("select * from users where id = #{id}")
  User getUser(Integer id);

}
