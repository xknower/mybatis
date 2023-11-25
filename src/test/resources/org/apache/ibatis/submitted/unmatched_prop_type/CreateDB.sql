drop table users if exists;

create table users (
  id int,
  name varchar(20),
  dob varchar(10)
);

insert into users (id, name, dob)
values (1, 'User1', '2000-01-01');
