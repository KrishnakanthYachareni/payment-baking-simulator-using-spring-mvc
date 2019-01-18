-- This Script will run automatically when application startup & You can access db by this url http://localhost:8080/h2
create table member(id int(20) PRIMARY KEY NOT NULL , username varchar (45), password varchar (45));

create table member_role(member_id int(20) PRIMARY KEY NOT NULL , role varchar (20));

insert into member(id,username,password) values(11,'user','password');
insert into member(id,username,password) values(12,'krishna','password');

insert into member_role(member_id,role) values(11,'USER_ROLE');
insert into member_role(member_id,role) values(12,'ADMIN_ROLE');

-- create table account(accountNo int(11) primary key not null , accountHolderName varchar(45), balance int(11), accountType varchar(45), dateOfBirth date, krCode varchar (45));