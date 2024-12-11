use test;
create table student (
     id bigint primary key,
     name varchar(10),
     address varchar(100),
     age int
);

truncate table student;

insert into student
values
    (1, "Cai_Guang", "501", 19),
    (2, "xhytom", "501", 20),
    (3, "GammaRays", "501", 20),
    (4, "fsl123", "7xx", 21),
    (5, "weiqt", "6xx", 22),
    (6, "lbromine", "1xx", 22);

select * from student;