drop table users if exists;

create table users (
  id int,
  name varchar(20)
);
create table udata (
  user_id int,
  num int
);

insert into users (id, name) values(1, 'User1');
insert into udata (user_id, num) values(1, 100);
insert into udata (user_id, num) values(1, 300);
