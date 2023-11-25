DROP TABLE parent if exists;
DROP TABLE child if exists;
create table parent(
    id integer, 
    value varchar(20)
);

create table child(
    id integer, 
    value varchar(20)
);

create table parent_child(
    idparent integer, 
    idchild_from integer, 
    idchild_to integer
);

insert into parent (id, value) values (1, 'parent1');
insert into parent (id, value) values (2, 'parent2');

insert into child (id, value) values (1, 'child1');
insert into child (id, value) values (2, 'child2');
insert into child (id, value) values (3, 'child3');
insert into child (id, value) values (4, 'child4');

insert into parent_child (idparent, idchild_from, idchild_to) values (1, 1, 2);
insert into parent_child (idparent, idchild_from, idchild_to) values (2, 2, 3);
insert into parent_child (idparent, idchild_from, idchild_to) values (2, 1, 2);
