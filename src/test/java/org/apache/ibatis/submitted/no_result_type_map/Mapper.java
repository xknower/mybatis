package org.apache.ibatis.submitted.no_result_type_map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Mapper extends ParentMapper<User> {

  User getUser(@Param("id") Integer id);

  List<User> getAllUsers();

}
