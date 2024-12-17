select * from user;
drop table User;

create table User (
  id bigint auto_increment,
  name varchar(20) not null,
  age int not null,
  password varchar(20) not null,
  primary key (id)
);