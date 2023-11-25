drop table users if exists;

create table Parent (
  id int,
  Name varchar(20),
  SurName varchar(20)
);

create table Child (
  id int,
  Name varchar(20),
  SurName varchar(20),
  Age int,
  ParentId varchar(20)
);

insert into Parent values (1, 'Jose', 'Garcia');
insert into Parent values (2, 'Juan', 'Perez');

insert into Child values (1, 'Ana', 'Garcia', 1, 1);
insert into Child values (2, 'Rosa', 'Garcia', 4, 1);

