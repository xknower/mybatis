package org.apache.ibatis.submitted.parent_reference_3level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.Reader;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlogTest {

  protected SqlSessionFactory sqlSessionFactory;

  String getConfigPath() {
    return "org/apache/ibatis/submitted/parent_reference_3level/mybatis-config.xml";
  }

  @BeforeEach
  void setUp() throws Exception {
    try (Reader reader = Resources.getResourceAsReader(getConfigPath())) {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    BaseDataTest.runScript(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(),
        "org/apache/ibatis/submitted/parent_reference_3level/CreateDB.sql");
  }

  @Test
  void testSelectBlogWithPosts() {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      Mapper mapper = session.getMapper(Mapper.class);
      Blog result = mapper.selectBlogByPrimaryKey(1);
      assertNotNull(result);
      assertEquals("Blog with posts", result.getTitle());
      Assertions.assertEquals(2, result.getPosts().size());
      Post firstPost = result.getPosts().get(0);
      Assertions.assertEquals(1, firstPost.getBlog().getId());
      Assertions.assertEquals(2, firstPost.getComments().size());
      Post secondPost = result.getPosts().get(1);
      Assertions.assertEquals(1, secondPost.getComments().size());
      Assertions.assertEquals(2, secondPost.getComments().get(0).getPost().getId());
    }
  }

  @Test
  void testSelectBlogWithoutPosts() {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      Mapper mapper = session.getMapper(Mapper.class);
      Blog result = mapper.selectBlogByPrimaryKey(2);
      assertNotNull(result);
      assertEquals("Blog without posts", result.getTitle());
      Assertions.assertEquals(0, result.getPosts().size());
    }
  }

  @Test
  void testSelectBlogWithPostsColumnPrefix() {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      Mapper mapper = session.getMapper(Mapper.class);
      Blog result = mapper.selectBlogByPrimaryKeyColumnPrefix(1);
      assertNotNull(result);
      assertEquals("Blog with posts", result.getTitle());
      Assertions.assertEquals(2, result.getPosts().size());
      Post firstPost = result.getPosts().get(0);
      Assertions.assertEquals(1, firstPost.getBlog().getId());
      Assertions.assertEquals(2, firstPost.getComments().size());
      Post secondPost = result.getPosts().get(1);
      Assertions.assertEquals(1, secondPost.getComments().size());
      Assertions.assertEquals(2, secondPost.getComments().get(0).getPost().getId());
    }
  }

  @Test
  void testSelectBlogWithoutPostsColumnPrefix() {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      Mapper mapper = session.getMapper(Mapper.class);
      Blog result = mapper.selectBlogByPrimaryKeyColumnPrefix(2);
      assertNotNull(result);
      assertEquals("Blog without posts", result.getTitle());
      Assertions.assertEquals(0, result.getPosts().size());
    }
  }
}
