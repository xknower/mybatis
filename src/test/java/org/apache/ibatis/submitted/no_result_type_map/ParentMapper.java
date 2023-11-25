package org.apache.ibatis.submitted.no_result_type_map;

import java.util.List;

public interface ParentMapper<T> {

  List<T> getAllUsersInParent();

}
