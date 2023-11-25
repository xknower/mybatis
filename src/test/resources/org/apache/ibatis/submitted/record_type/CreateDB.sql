drop table prop if exists;

create table prop (
  id int, 
  val varchar(20),
  url varchar(32)
);

insert into prop (id, val, url) values (1, 'Val1', 'https://www.google.com');

create table item (
  id int,
  prop_id int
);

insert into item (id, prop_id) values (100, 1);
