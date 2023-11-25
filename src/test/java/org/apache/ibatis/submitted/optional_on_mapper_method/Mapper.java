package org.apache.ibatis.submitted.optional_on_mapper_method;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

  @Select("select * from users where id = #{id}")
  Optional<User> getUserUsingAnnotation(Integer id);

  Optional<User> getUserUsingXml(Integer id);

}
