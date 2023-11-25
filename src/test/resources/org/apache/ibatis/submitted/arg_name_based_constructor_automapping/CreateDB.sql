drop table users if exists;

create table users (
  id int,
  name varchar(20),
  team int
);

insert into users (id, name, team) values
(1, 'User1', 99);

drop table tasks if exists;

create table tasks (
  id int,
  name varchar(20),
  assignee_id int
);

insert into tasks (id, name, assignee_id) values
(11, 'Task1', 1);
