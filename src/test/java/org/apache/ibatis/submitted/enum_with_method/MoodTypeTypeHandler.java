package org.apache.ibatis.submitted.enum_with_method;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MoodTypeTypeHandler extends BaseTypeHandler<Mood> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, Mood parameter, JdbcType jdbcType) throws SQLException {
    ps.setInt(i, parameter.getValue());
  }

  @Override
  public Mood getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return Mood.fromValue(rs.getInt(columnName));
  }

  @Override
  public Mood getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return Mood.fromValue(rs.getInt(columnIndex));
  }

  @Override
  public Mood getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return Mood.fromValue(cs.getInt(columnIndex));
  }

}
