DROP SCHEMA PUBLIC CASCADE;

SET DATABASE SQL SYNTAX MYS TRUE;


-- V1__create_users_table

create table users (
    id int not null auto_increment,
    name varchar(100),
    primary key (id)
);