create table departments(
	id serial primary key,
	name varchar(255)
);

create table employes(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

insert into departments (name) values
	('First department'), ('Second department'), ('Third department'), ('Fourth department');
insert into employes (name, departments_id) values
	('Ivan', 1), ('Klava', 1), ('Stepan', 1),
	('Oleg', 2), ('Olga', 2),
	('Petr', 3);

select *
from departments d
left join employes e on e.departments_id = d.id;

select *
from departments d
right join employes e on e.departments_id = d.id;

select *
from departments d
full join employes e on d.id = e.departments_id;

select * from departments d cross join employes e;

select *
from departments d
left join employes e on d.id = e.departments_id where e.departments_id is null;

select *
from departments d
left join employes e on e.departments_id = d.id where e.departments_id is not null;

select *
from departments d
right join employes e on e.departments_id = d.id;

-- left и right join написать запросы, которые давали бы одинаковый результат.
select * from departments as d left join emploees as e on e.departments_id = d.id;
select * from emploees as e right join departments as d on e.departments_id = d.id;

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens (name, gender) values
	('Olga', 'female'), ('Ivan', 'male'), ('Oleg', 'male'),
	('Sergey', 'male'), ('Irina', 'female');

select (t1.name || ' ' || t2.name) as "pair"
from teens t1
cross join teens t2 where t1.gender <> t2.gender and t1.gender = 'male';