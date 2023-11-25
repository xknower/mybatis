package org.apache.ibatis.submitted.result_handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class UserResultHandler implements ResultHandler {
  private final List<User> users;

  public UserResultHandler() {
    users = new ArrayList<>();
  }

  @Override
  public void handleResult(ResultContext context) {
    User user = (User) context.getResultObject();
    users.add(user);
  }

  public List<User> getUsers() {
    return users;
  }
}
