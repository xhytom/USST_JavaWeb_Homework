drop table User;

create table User (
  id bigint auto_increment,
  phone char(11),
  password varchar(20),
  primary key (id)
);

select * from User;

delete from User;