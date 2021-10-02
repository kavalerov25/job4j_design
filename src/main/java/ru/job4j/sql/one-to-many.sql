create table position(
    id serial primary key,
    name varchar(255)
);

create table soldat(
    id serial primary key,
    name varchar(255),
    position_id int references position(id)
);

insert into position(name) values ('captain');
insert into employees(name, position_id) VALUES ('Kirill', 1);

select * from employees;

select * from position where id in (select id from employees);
