drop table users if exists;

create table users (
  id int,
  name varchar(20),
  friend_id int
);

create sequence IF NOT EXISTS cursor_cache_oom START WITH 1 INCREMENT BY 1;

insert into users (id, name, friend_id)
SELECT nr, 'test' + nr, mod((nr + 1), 10000) + 1
from unnest(sequence_array(1, 10000, 1)) as i(nr);
