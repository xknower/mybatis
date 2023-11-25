package org.apache.ibatis.submitted.manyanno;

import java.util.List;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PostMapper {

  @Select("select * from post where author_id = #{id} order by id")
  // @formatter:off
  @Results(value = {
      @Result(property = "id", column = "id"),
      @Result(property = "subject", column = "subject"),
      @Result(property = "body", column = "body"),
      @Result(property = "tags", javaType = List.class, column = "id", many = @Many(select = "getTagsForPost"))
    })
  // @formatter:on
  List<AnnoPost> getPosts(int authorId);

  @Select("select t.id, t.name from tag t inner join post_tag pt on pt.tag_id = t.id where pt.post_id = #{postId} order by id")
  // @formatter:off
  @ConstructorArgs(value = {
      @Arg(column = "id", javaType = int.class),
      @Arg(column = "name", javaType = String.class)
    })
  // @formatter:on
  List<AnnoPostTag> getTagsForPost(int postId);

}
