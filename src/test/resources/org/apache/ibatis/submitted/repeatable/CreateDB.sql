drop table users if exists;

create table users (
  id int,
  name varchar(20)
);

insert into users (id, name) values((select count(*) + 1 from users), 'User1');
insert into users (id, name) values((select count(*) + 1 from users), 'User1 HSQL');
insert into users (id, name) values((select count(*) + 1 from users), 'User1 DERBY');
insert into users (id, name) values((select count(*) + 1 from users), 'User1 DEFAULT');
