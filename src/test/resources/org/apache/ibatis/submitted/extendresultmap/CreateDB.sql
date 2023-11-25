drop table test if exists;

create table test (
    A VARCHAR(32) not null,
    B VARCHAR(32) not null
);

INSERT INTO test VALUES('A1', 'B1');
INSERT INTO test VALUES('A2', 'B2');
