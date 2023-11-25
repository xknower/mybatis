DROP TABLE country IF EXISTS;
DROP TABLE planet IF EXISTS;

CREATE TABLE country (
  Id int IDENTITY,
  countryname varchar(255) DEFAULT NULL,
  countrycode varchar(255) DEFAULT NULL,
);

CREATE TABLE planet (
  id int IDENTITY,
  name varchar(32) DEFAULT NULL,
  code varchar(64) GENERATED ALWAYS AS (name || '-' || id)
);
