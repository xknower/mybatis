package org.apache.ibatis.submitted.column_prefix;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

class ColumnPrefixNestedQueryTest extends ColumnPrefixTest {
  @Override
  protected List<Pet> getPetAndRoom(SqlSession sqlSession) {
    return sqlSession.selectList("org.apache.ibatis.submitted.column_prefix.MapperNestedQuery.selectPets");
  }

  @Override
  protected List<Person> getPersons(SqlSession sqlSession) {
    return sqlSession.selectList("org.apache.ibatis.submitted.column_prefix.MapperNestedQuery.selectPersons");
  }

  @Override
  protected String getConfigPath() {
    return "org/apache/ibatis/submitted/column_prefix/ConfigNestedQuery.xml";
  }
}
