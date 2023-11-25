package org.apache.ibatis.submitted.results_id;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;

import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Test;

class IdConflictTest {

  @Test
  void shouldFailOnDuplicatedId() {
    Configuration configuration = new Configuration();
    when(() -> configuration.addMapper(IdConflictMapper.class));
    then(caughtException()).isInstanceOf(RuntimeException.class).hasMessage(
        "Result Maps collection already contains key org.apache.ibatis.submitted.results_id.IdConflictMapper.userResult");
  }

}
