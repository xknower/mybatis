drop table product_sku if exists;
drop table product_info if exists;
drop table product if exists;

create table product (
  id varchar(32) not null,
  code varchar(80) not null,
  name varchar(240) not null
);

create table product_sku (
  id varchar(32) not null,
  product_id varchar(32) not null,
  code varchar(80) not null,
  color varchar(40),
  size varchar(40)
);

create table product_info (
  id int  not null,
  product_id varchar(32) not null,
  other_info varchar(240)
);

insert into product(id, code, name) values('10000000000000000000000000000001', 'P001', 'Product 001');
insert into product_sku(id ,product_id, code, color, size) values('20000000000000000000000000000001', '10000000000000000000000000000001', 'S001', 'red', '80');
insert into product_sku(id ,product_id, code, color, size) values('20000000000000000000000000000002', '10000000000000000000000000000001', 'S001', 'blue', '10');
insert into product_info(id, product_id, other_info) values(1, '10000000000000000000000000000001', 'Sale 50% Off');
