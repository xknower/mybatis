package org.apache.ibatis.submitted.cursor_cache_oom;

import org.apache.ibatis.cursor.Cursor;

public interface Mapper {

  User getUser(Integer id);

  void insertUser(User user);

  Cursor<User> fetchUsers();
}
