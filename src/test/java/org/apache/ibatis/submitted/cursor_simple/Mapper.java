package org.apache.ibatis.submitted.cursor_simple;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;

public interface Mapper {

  Cursor<User> getAllUsers();

  // @formatter:off
  @Select({
      "select null id, null name from (values (0))",
      "union all",
      "select 99 id, 'Kate' name from (values (0))",
      "union all",
      "select null id, null name from (values (0))",
      "union all",
      "select null id, null name from (values (0))"
    })
  // @formatter:on
  Cursor<User> getNullUsers(RowBounds rowBounds);

  @Select("select * from users")
  @Options(fetchSize = Integer.MIN_VALUE)
  Cursor<User> getUsersMysqlStream();
}
